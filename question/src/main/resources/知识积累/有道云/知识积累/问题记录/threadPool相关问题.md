
[toc]
##### 问题概览

- 线程池好处
- 多线程怎么创建
- 线程池参数
- execute执行流程
- worker
- 没有工作会删除线程吗？
- 最大线程满了之后？

##### 1.线程池化好处
```

    1、线程池的重用
    线程池的创建和销毁的开销巨大，通过线程池的重用大大减少了这些不必要的开销，既然减少了内存开销，其线程执行速度也回提高。
    2、控制线程池的并发数
    控制线程池的并发数可以有效的避免大量的线程池争夺CPU资源而造成堵塞。
    3、线程池也可以对线程进行管理
    线程池可以提供定时、定期、单线程、并发数控制等功能。比如通过SheduledThreadPool线程池来执行S秒后，每隔N秒执行一次的任务。

```
##### 2.线程池创建
```

4个构造方法->7个参数，根据参数选择调用构造方法
```
##### 3.核心参数
```
*corePoolSize:线程池的核心线程数。
*maximumPoolSize:线程池允许的最大线程数。
*keepAliveTime:超过核心线程数时闲置线程的存活时间。
*workQueue:任务执行前保存任务的队列，保存由execute方法提交的Runnable任务。
```
##### 4.execute执行流程 
###### 4.1 or 线程池如何接收并执行一个或者多个任务？
###### 4.2 or线程池中的线程间是如何调度的？即调度机制是什么？
```
创建流程 workCnt、coreThreadNum、MaxThreadNum 
据线程池的状态以及当前线程数(workerCount)判断是否需要新增一个worker，
还是直接放入等待队列，还是执行拒绝策略。
```
```
 /*
     * Proceed in 3 steps:
     *
     * 1. If fewer than corePoolSize threads are running, try to
     * start a new thread with the given command as its first
     * task.  The call to addWorker atomically checks runState and
     * workerCount, and so prevents false alarms that would add
     * threads when it shouldn't, by returning false.
     *
     * 2. If a task can be successfully queued, then we still need
     * to double-check whether we should have added a thread
     * (because existing ones died since last checking) or that
     * the pool shut down since entry into this method. So we
     * recheck state and if necessary roll back the enqueuing if
     * stopped, or start a new thread if there are none.
     *
     * 3. If we cannot queue task, then we try to add a new
     * thread.  If it fails, we know we are shut down or saturated
     * and so reject the task.
     */
    执行流程分三步
    1.在执行的线程数 < corePoolSize,新建线程。调用方法addWorker 自动检查运行状态
    和wokerCount数量。防止错误情况下增加线程，返回false。
    2.如果一个任务成功增加到队列中，仍需要双重检测是否应该增加线程（因为存在上次检测后
    死掉的线程）或者线程池从上次进入这个方法时停止。所以需要再次检测状态，必要的时候回滚
    或者队列没有线程是要启动新的线程。
    3.队列中无法增加新的任务,尝试新增一个线程,如果失败应该是停止或者队列饱和，所以拒绝
    这个任务。

```

``` java
public void execute(Runnable command) {
    if (command == null)
        throw new NullPointerException();
    int c = ctl.get();
    // worker数量比核心线程数小，直接创建worker执行任务
    if (workerCountOf(c) < corePoolSize) {
        if (addWorker(command, true))
            return;
        c = ctl.get();
    }
    // worker数量超过核心线程数，任务直接进入队列
    if (isRunning(c) && workQueue.offer(command)) {
        int recheck = ctl.get();
        // 线程池状态不是RUNNING状态，说明执行过shutdown命令，需要对新加入的任务执行reject()操作。
        // 这儿为什么需要recheck，是因为任务入队列前后，线程池的状态可能会发生变化。
        if (! isRunning(recheck) && remove(command))
            reject(command);
        // 这儿为什么需要判断0值，主要是在线程池构造方法中，核心线程数允许为0
        else if (workerCountOf(recheck) == 0)
            addWorker(null, false);
    }
    // 如果线程池不是运行状态，或者任务进入队列失败，则尝试创建worker执行任务。
    // 这儿有3点需要注意：
    // 1. 线程池不是运行状态时，addWorker内部会判断线程池状态
    // 2. addWorker第2个参数表示是否创建核心线程
    // 3. addWorker返回false，则说明任务执行失败，需要执行reject操作
    else if (!addWorker(command, false))
        reject(command);
}
```
##### 5. worker
```
线程池worker任务单元
任务封装在一个Worker类

通过构造函数可以知道，创建Worker对象就会创建一个线程，但是线程传递的参数是this，即该Worker对象，会不会感到很奇怪？！
为什么不直接把firstTask传递给新创建的线程呢？！这是一个很关键的点，如果如我们所愿，firstTask任务直接传递给新线程，
那么当firstTask执行完之后，该线程如何获取队列中的任务呢？或许你有更好的方法，但这里采用下面这种思想：
把去等待队列中获取任务的过程封装成一个Runnable任务(就是该Worker对象)，新创建的线程启动后，就会执行该Runnable任务，
该Runnable任务执行完firstTask任务后，就会不断的从等待队列中获取任务，直到等待队列为空，该线程才会销毁
```


``` java
private final class Worker
    extends AbstractQueuedSynchronizer
    implements Runnable
{
    /**
     * This class will never be serialized, but we provide a
     * serialVersionUID to suppress a javac warning.
     */
    private static final long serialVersionUID = 6138294804551838833L;

    /** Thread this worker is running in.  Null if factory fails. */
    final Thread thread;
    /** Initial task to run.  Possibly null. */
    Runnable firstTask;
    /** Per-thread task counter */
    volatile long completedTasks;

    /**
     * Creates with given first task and thread from ThreadFactory.
     * @param firstTask the first task (null if none)
     */
    Worker(Runnable firstTask) {
        setState(-1); // inhibit interrupts until runWorker
        this.firstTask = firstTask;
        // 这儿是Worker的关键所在，使用了线程工厂创建了一个线程。传入的参数为当前worker
        this.thread = getThreadFactory().newThread(this);
    }
     代理
    /** Delegates main run loop to outer runWorker  */
    public void run() {
        runWorker(this);
    }

    // 省略代码...
}
```
##### 6.没有工作会删除线程吗？
###### 6.1 or 线程池中的线程如何创建？何时创建？存活到何时？
###### 6.2 or 线程池如何销毁？何时销毁？
 
```
线程池内的存活时间也跟任务数有关；
如果线程一直处于工作状态，那么一直存活；
如果有池内线程数大于核心线程数且有空闲线程，那么空闲线程等待keepAliveTime之后进行销毁；
如果池内线程数小于核心线程数且有空闲线程，线程不会销毁，
除非设置了allowCoreThreadTimeOut属性(true/false)，其值默认为false，核心线程不会销毁，若设置为true，
则空闲核心线程维持keepAliveTime时间后销毁。
```
#####  7.最大线程满了之后？
```
理解为流程解释，最大线程满了=>addworker()->reject
```

#### 8.线程池如何存放多余任务？
 ```
    队列  
    Direct handoffs 等待队列(workQueue)
    Unbounded queues.使用无界队列(例如没有预定义容量的LinkedBlockingQueue)
    Bounded queues.当使用有限的maximumPoolSize时，有界队列(例如ArrayBlockingQueue)
```

#### 9.线程池状态
```  
     线程池的五种状态，从侧面也反应出线程池的生命周期，线程池某刻的状态用一个AtomicInteger变量ctl来表示，
     变量ctl可以说明线程池的两个属性：工作线程数(workerCount)和运行状态(runState)；
     线程池一旦创建则workerCount默认为0，runState为RUNNING。


     运行(RUNNING)：该状态下的线程池接收新任务并处理队列中的任务；线程池创建完毕就处于该状态，也就是正常状态；
     关机(SHUTDOWN)：线程池不接受新任务，但处理队列中的任务；线程池调用shutdown()之后的池状态；
     停止(STOP)：线程池不接受新任务，也不处理队列中的任务，并中断正在执行的任务；线程池调用shutdownNow()之后的池状态；
     清理(TIDYING)：线程池所有任务已经终止，workCount(当前线程数)为0；过渡到清理状态的线程将运行terminated()钩子方法；
     终止(TERMINATED)：terminated()方法结束后的线程池状态；
     
```







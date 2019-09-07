package threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhiwei.liu003
 * @date 2019/8/2622:00
 */
public class ThreadPoolTest {


    public static void main(String[] args) throws Exception {

        // 开始时间
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<String>();
        int total = 100;
        for (int i = 1; i <= total; i++) {
            list.add(i + "");
        }
        // 每20条数据开启一条线程
        int threadSize = 20;
        // 总数据条数
        int dataSize = list.size();
        // 线程数
        int threadNum = dataSize / threadSize + 1;
        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % threadSize == 0;

        // 创建一个线程池
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        // 定义一个任务集合
        List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
        Callable<Integer> task = null;
        List<String> cutList = null;
        long begaintime = System.currentTimeMillis();
        // 确定每条线程的数据
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(threadSize * i, dataSize);
            } else {
                cutList = list.subList(threadSize * i, threadSize * (i + 1));
            }
            // System.out.println("第" + (i + 1) + "组：" + cutList.toString());
            final List<String> listStr = cutList;
            task = new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    System.out.println(Thread.currentThread().getName() + "线程：" + listStr);
                    return 1;
                }
            };
            // 这里提交的任务容器列表和返回的Future列表存在顺序对应的关系
            tasks.add(task);
        }

        List<Future<Integer>> results = exec.invokeAll(tasks);

        for (Future<Integer> future : results) {
            System.out.println(future.get());
        }

        // 关闭线程池
        exec.shutdown();
//
//        try {
//            countDownLatch.await();  //这一步是为了将全部线程任务执行完以后，开始执行后面的任务（计算时间，数量）
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long endTime = System.currentTimeMillis(); //结束时间
//        System.out.println(total + " 个  接口请求总耗时 ： "+(endTime-begaintime)+"-----平均耗时为"+ ((endTime-begaintime)/total));
        System.out.println("线程任务执行结束");
    }
}

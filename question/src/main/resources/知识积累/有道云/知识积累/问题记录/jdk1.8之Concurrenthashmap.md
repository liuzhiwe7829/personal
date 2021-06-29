##### Concurrenthashmap
```
如何保证线程安全?说说你的理解
1.8
参考
https://www.cnblogs.com/junjiang3/p/8686290.html
https://www.cnblogs.com/wuzhenzhao/p/12600226.html
简述
与hashMap类型put、get等方法
ConcurrentHashMap中大量使用U.compareAndSwapXXX方法
这个方法利用一个CAS算法实现无所化的修改值的操作，大大降低锁带来的性能消耗。与乐观锁，svn的思想比较类似

与1.7比较
它做了两个改进

1、取消了 segment 分段设计，直接使用 Node 数组来保存数据，并且采用 Node 数组元素作为锁来实现每一行数据进行加锁来进一步减少并发冲突的概率
2、将原本数组+单向链表的数据结构变更为了数组+单向链表+红黑树的结构。
为什么要引入红黑树呢？
在正常情况下，key hash 之后如果能够很均匀的分散在数组中，那么 table 数组中的每个队列的长度主要为 0或者1.
但是实际情况下，还是会存在一些队列长度过长的情况。如果还采用单向列表方式，那么查询某个节点的时间复杂度就变为 O(n);
因此对于队列长度超过 8 的列表，JDK1.8 采用了红黑树的结构，那么查询的时间复杂度就会降低到O(logN),可以提升查找的性能；

------ 此处解答归为1.8版本hashMap结构原因 
```
#### unsafe 定义
```
 // Unsafe mechanics
    private static final sun.misc.Unsafe U;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final long ABASE;
    private static final int ASHIFT;

    static {
        try {
            U = sun.misc.Unsafe.getUnsafe();
            Class<?> k = ConcurrentHashMap.class;
            SIZECTL = U.objectFieldOffset
                (k.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = U.objectFieldOffset
                (k.getDeclaredField("transferIndex"));
            BASECOUNT = U.objectFieldOffset
                (k.getDeclaredField("baseCount"));
            CELLSBUSY = U.objectFieldOffset
                (k.getDeclaredField("cellsBusy"));
            Class<?> ck = CounterCell.class;
            CELLVALUE = U.objectFieldOffset
                (ck.getDeclaredField("value"));
            Class<?> ak = Node[].class;
            ABASE = U.arrayBaseOffset(ak);
            int scale = U.arrayIndexScale(ak);
            if ((scale & (scale - 1)) != 0)
                throw new Error("data type scale not a power of two");
            ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }
```
#### unsafe 补充
https://www.jb51.net/article/140726.htm

定义三个原子操作，用于对指定位置的节点进行操作。
这三种原子操作被广泛使用在ConcurrentHashMap的get和put等方法中。正是这些原子操作保证了ConcurrentHashMap的线程安全。

```
 /* ---------------- Table element access -------------- */

    /*
     * Volatile access methods are used for table elements as well as
     * elements of in-progress next table while resizing.  All uses of
     * the tab arguments must be null checked by callers.  All callers
     * also paranoically precheck that tab's length is not zero (or an
     * equivalent check), thus ensuring that any index argument taking
     * the form of a hash value anded with (length - 1) is a valid
     * index.  Note that, to be correct wrt arbitrary concurrency
     * errors by users, these checks must operate on local variables,
     * which accounts for some odd-looking inline assignments below.
     * Note that calls to setTabAt always occur within locked regions,
     * and so in principle require only release ordering, not
     * full volatile semantics, but are currently coded as volatile
     * writes to be conservative.
     */
    /**
     * 原子操作方法被使用在table元素和下一个table在扩容时。所有的tab
     * 参数必须要检查。 tab 长度非0，从而保证indx参数(hash值和 长度-1 )的合法性(
     * 因为hash&(length-1))。保证一致性，这些校验必须用本地变量 。呸
     */
    @SuppressWarnings("unchecked")
    static final <K,V> Node<K,V> tabAt(Node<K,V>[] tab, int i) {
        return (Node<K,V>)U.getObjectVolatile(tab, ((long)i << ASHIFT) + ABASE);
    }

    static final <K,V> boolean casTabAt(Node<K,V>[] tab, int i,
                                        Node<K,V> c, Node<K,V> v) {
        return U.compareAndSwapObject(tab, ((long)i << ASHIFT) + ABASE, c, v);
    }

    static final <K,V> void setTabAt(Node<K,V>[] tab, int i, Node<K,V> v) {
        U.putObjectVolatile(tab, ((long)i << ASHIFT) + ABASE, v);
    }

```
#### put 方法第一阶段：
```
public V put(K key, V value) {
        return putVal(key, value, false);
    }

/** Implementation for put and putIfAbsent */
final V putVal(K key, V value, boolean onlyIfAbsent) {
　　if (key == null || value == null) throw new NullPointerException();
　　int hash = spread(key.hashCode());//计算 hash 值
　　int binCount = 0;//用来记录链表的长度
　　for (Node<K,V>[] tab = table;;) {//这里其实就是自旋操作，当出现线程竞争时不断自旋
　　　　Node<K,V> f; int n, i, fh;
　　　　if (tab == null || (n = tab.length) == 0)//如果数组为空，则进行数组初始 化
　　　　　　tab = initTable();//初始化数组
　　　　　　//通过 hash 值对应的数组下标得到第一个节点; 以 volatile 读的方式来读取 table 数
　　　　　　//组中的元素，保证每次拿到的数据都是最新的
　　　　　　//(Node<K,V>)U.getObjectVolatile(tab, ((long)i << ASHIFT) + ABASE);
　　　　else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
　　　　　　 //如果该下标返回的节点为空，则直接通过 cas 将新的值封装成 node 插入即可；
　　　　　　//如果 cas 失败，说明存在竞争，则进入下一次循环
　　　　　　if (casTabAt(tab, i, null,new Node<K,V>(hash, key, value, null)))
　　　　　　　　break; // no lock when adding to empty bin
　　　　　　}　　　　}
        .......
}

假如在上面这段代码中存在两个线程，在不加锁的情况下：
线程 A 成功执行 casTabAt 操作后，随后的线程 B 可以通过 tabAt 方法立刻看到 table[i]的改变。
原因如下：线程 A 的casTabAt 操作，具有 volatile 读写相同的内存语义，
根据 volatile 的 happens-before 规则：线程 A 的 casTabAt 操作，一定对线程 B 的 tabAt 操作可见。
```
##### initTable()：
```
　　数组初始化方法，这个方法比较简单，就是初始化一个合适大小的数组
sizeCtl 这个要单独说一下，如果没搞懂这个属性的意义，可能会被搞晕这个标志是在 Node
数组初始化或者扩容的时候的一个控制位标识，负数代表正在进行初始化或者扩容操作 

-1 代表正在初始化
-N 代表有 N-1 有二个线程正在进行扩容操作，这里不是简单的理解成 n 个线程，sizeCtl 就是-N,这块后续在讲扩容的时候会说明
0 标识 Node 数组还没有被初始化，正数代表初始化或者下一次扩容的大小
```
```
private final Node<K,V>[] initTable() {
        Node<K,V>[] tab; int sc;
        while ((tab = table) == null || tab.length == 0) {
            if ((sc = sizeCtl) < 0)//被其他线程抢占了初始化的操作,则直接让出自己的 CPU 时间片
                Thread.yield(); // lost initialization race; just spin
            //通过 cas 操作，将 sizeCtl 替换为-1，标识当前线程抢占到了初始化资格
            //第一次进来初始化一定走这里
            else if (U.compareAndSwapInt(this, SIZECTL, sc, -1)) {
                try {
                    if ((tab = table) == null || tab.length == 0) {
                        //默认初始容量为 16
                        int n = (sc > 0) ? sc : DEFAULT_CAPACITY;
                        @SuppressWarnings("unchecked")
                        //初始化数组，长度为 16，或者初始化在构造 ConcurrentHashMap 的时候传入的长度
                        Node<K,V>[] nt = (Node<K,V>[])new Node<?,?>[n];
                        table = tab = nt;//将这个数组赋值给 table
                        //计算下次扩容的大小，实际就是当前容量的 0.75倍，这里使用了右移来计算
                        //sc =12
                        sc = n - (n >>> 2);
                    }
                } finally {
                    //设置 sizeCtl 为 sc, 如果默认是 16 的话，那么这个时候sc=16*0.75=12
                    sizeCtl = sc;
                }
                break;
            }
        }
        return tab;
}
```
##### tabAt()：
```
该方法获取对象中offset偏移地址对应的对象field的值。
实际上这段代码的含义等价于tab[i],但是为什么不直接使用 tab[i]来计算呢？
getObjectVolatile，一旦看到 volatile 关键字，就表示可见性。
因为对 volatile 写操作 happen-before 于 volatile 读操作，
因此其他线程对 table 的修改均对 get 读取可见；
虽然 table 数组本身是增加了 volatile 属性，但是“volatile 的数组只针对数组的引用具有volatile 的语义，而不是它的元素”。 
所以如果有其他线程对这个数组的元素进行写操作，那么当前线程来读的时候不一定能读到最新的值。
出于性能考虑，Doug Lea 直接通过 Unsafe 类来对 table 进行操作。
```
```
    @SuppressWarnings("unchecked")
    static final <K,V> Node<K,V> tabAt(Node<K,V>[] tab, int i) {
        return (Node<K,V>)U.getObjectVolatile(tab, ((long)i << ASHIFT) + ABASE);
    }
```
#### put 方法第二阶段
```
在putVal方法执行完成以后，会通过addCount来增加ConcurrentHashMap中的元素个数，并且还会可能触发扩容操作。这里会有两个非常经典的设计

1.高并发下的扩容
2.如何保证 addCount 的数据安全性以及性能
```

```
……
　　//将当前 ConcurrentHashMap 的元素数量加 1，有可能触发 transfer 操作(扩容)
　　addCount(1L, binCount);
　　return null;
}

```
##### addCount()：
```
在 putVal 最后调用 addCount 的时候，传递了两个参数，分别是 1 和 binCount(链表长度)，
看看 addCount 方法里面做了什么操作。x 表示这次需要在表中增加的元素个数，check 参数表示是否需要进行扩容检查，
大于等于 0都需要进行检查
```
```
private final void addCount(long x, int check) {
        CounterCell[] as; long b, s;
//        判断 counterCells 是否为空，
//        1. 如果为空，就通过 cas 操作尝试修改 baseCount 变量，对这个变量进行原子累加操
//        作(做这个操作的意义是：如果在没有竞争的情况下，仍然采用 baseCount 来记录元素个 数)
//        2. 如果 cas 失败说明存在竞争，这个时候不能再采用 baseCount 来累加，而是通过 CounterCell 来记录
        if ((as = counterCells) != null ||
                !U.compareAndSwapLong(this, BASECOUNT, b = baseCount, s = b + x)) {
            CounterCell a; long v; int m;
            boolean uncontended = true;//是否冲突标识，默认为没有冲突
//            这里有几个判断
//            1. 计数表为空则直接调用 fullAddCount
//            2. 从计数表中随机取出一个数组的位置为空，直接调用 fullAddCount
//            3. 通过 CAS 修改 CounterCell 随机位置的值，如果修改失败说明出现并发情况（这里又
//            用到了一种巧妙的方法），调用 fullAndCount
//            Random 在线程并发的时候会有性能问题以及可能会产生相同的随机
//            数 ,ThreadLocalRandom.getProbe 可以解决这个问题，并且性能要比 Random 高
            if (as == null || (m = as.length - 1) < 0 ||
                    (a = as[ThreadLocalRandom.getProbe() & m]) == null ||
                    !(uncontended =
                            U.compareAndSwapLong(a, CELLVALUE, v = a.value, v + x))) {
                fullAddCount(x, uncontended);//执行 fullAddCount 方法
                return;
            }
            if (check <= 1)//链表长度小于等于 1，不需要考虑扩容
                return;
            s = sumCount();//统计 ConcurrentHashMap 元素个数
        }
    .......
}
```
##### CounterCells 解释：
```
　　ConcurrentHashMap 是采用 CounterCell 数组来记录元素个数的，像一般的集合记录集合大小，
　　直接定义一个 size 的成员变量即可，当出现改变的时候只要更新这个变量就行。
　　为什么ConcurrentHashMap 要用这种形式来处理呢？
　　问题还是处在并发上，ConcurrentHashMap是并发集合，如果用一个成员变量来统计元素个数的话，
　　为了保证并发情况下共享变量的的安全性，势必会需要通过加锁或者自旋来实现，
　　如果竞争比较激烈的情况下，size 的设置上会出现比较大的冲突反而影响了性能，
　　所以在ConcurrentHashMap 采用了分片的方法来记录大小，具体什么意思，我们来分析下
```

```
private transient volatile int cellsBusy;// 标识当前 cell 数组是否在初始化或扩容中的CAS 标志位
/**
* Table of counter cells. When non-null, size is a power of 2.
*/
private transient volatile CounterCell[] counterCells;// counterCells 数组，总数值的分值分别存在每个 cell 中

@sun.misc.Contended static final class CounterCell {
　　volatile long value;
　　CounterCell(long x) { value = x; }
}
//看到这段代码就能够明白了，CounterCell 数组的每个元素，都存储一个元素个数，而实际我们调用size 方法就是通过这个循环累加来得到的
//又是一个设计精华，大家可以借鉴； 有了这个前提，再会过去看 addCount 这个方法，就容易理解一些了
final long sumCount() {
　　CounterCell[] as = counterCells; CounterCell a;
　　long sum = baseCount;
　　if (as != null) {
　　　　for (int i = 0; i < as.length; ++i) {
　　　　　　if ((a = as[i]) != null)
　　　　　　　　sum += a.value;
　　　　　　}
　　　　}
　　return sum;
}
```
##### fullAddCount()：
```
fullAddCount 主要是用来初始化 CounterCell，来记录元素个数，里面包含扩容，初始化等操作


private final void fullAddCount(long x, boolean wasUncontended) {
        int h;
        //获取当前线程的 probe 的值，如果值为 0，则初始化当前线程的 probe 的值,probe 就是随机数
        if ((h = ThreadLocalRandom.getProbe()) == 0) {
            ThreadLocalRandom.localInit();      // force initialization
            h = ThreadLocalRandom.getProbe();
            wasUncontended = true; // 由于重新生成了 probe，未冲突标志位设置为 true
        }
        boolean collide = false;                // True if last slot nonempty
        for (;;) {//自旋
            CounterCell[] as; CounterCell a; int n; long v;
            //说明 counterCells 已经被初始化过了，我们先跳过这个代码，先看初始化部分
            if ((as = counterCells) != null && (n = as.length) > 0) {
                // 通过该值与当前线程 probe 求与，获得cells 的下标元素，和 hash 表获取索引是一样的
                if ((a = as[(n - 1) & h]) == null) {
                    //cellsBusy=0 表示 counterCells 不在初始化或者扩容状态下
                    if (cellsBusy == 0) {// Try to attach new Cell
                        //构造一个 CounterCell 的值，传入元素个数
                        CounterCell r = new CounterCell(x); // Optimistic create
                        //通过 cas 设置 cellsBusy 标识，防止其他线程来对 counterCells 并发处理
                        if (cellsBusy == 0 &&
                                U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                            boolean created = false;
                            try {               // Recheck under lock
                                CounterCell[] rs; int m, j;
                                //将初始化的 r 对象的元素个数放在对应下标的位置
                                if ((rs = counterCells) != null &&
                                        (m = rs.length) > 0 &&
                                        rs[j = (m - 1) & h] == null) {
                                    rs[j] = r;
                                    created = true;
                                }
                            } finally {//恢复标志位
                                cellsBusy = 0;
                            }
                            if (created)//创建成功，退出循环
                                break;
                            //说明指定 cells 下标位置的数据不为空，则进行下一次循环
                            continue;           // Slot is now non-empty
                        }
                    }
                    collide = false;
                }
                //说明在 addCount 方法中 cas 失败了，并且获取 probe 的值不为空
                else if (!wasUncontended)       // CAS already known to fail
                    // 设置为未冲突标识，进入下一次自旋
                    wasUncontended = true;      // Continue after rehash
                // 由于指定下标位置的 cell 值不为空，则直接通过 cas 进行原子累加，如果成功，则直接退出
                else if (U.compareAndSwapLong(a, CELLVALUE, v = a.value, v + x))
                    break;
                // 如果已经有其他线程建立了新的 counterCells
                // 或者 CounterCells 大于 CPU 核心数（很巧妙，线程的并发数不会超过 cpu 核心数）
                else if (counterCells != as || n >= NCPU)
                    //设置当前线程的循环失败不进行扩容
                    collide = false;            // At max size or stale
                else if (!collide)//恢复 collide 状态，标识下次循环会进行扩容
                    collide = true;
                //进入这个步骤，说明 CounterCell 数组容量不够，线程竞争较大，所以先设置一个标识表示为正在扩容
                else if (cellsBusy == 0 &&
                        U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                    try {
                        if (counterCells == as) {// Expand table unless stale
                            // 扩容一倍 2 变成 4 ，这个扩容比较简单
                            CounterCell[] rs = new CounterCell[n << 1];
                            for (int i = 0; i < n; ++i)
                                rs[i] = as[i];
                            counterCells = rs;
                        }
                    } finally {
                        cellsBusy = 0;//恢复标识
                    }
                    collide = false;
                    // 继续下一次自旋
                    continue;                   // Retry with expanded table
                }//更新随机数的值
                h = ThreadLocalRandom.advanceProbe(h);
            }
            //cellsBusy=0 表示没有在做初始化，通过 cas 更新 cellsbusy 的值标注当前线程正在做初始化操作
            else if (cellsBusy == 0 && counterCells == as &&
                    U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                boolean init = false;
                try {                           // Initialize table
                    if (counterCells == as) { //初始化容量为 2
                        CounterCell[] rs = new CounterCell[2];
                        //将 x 也就是元素的个数放在指定的数组下标位置
                        rs[h & 1] = new CounterCell(x);
                        counterCells = rs;//赋值给 counterCells
                        init = true;//设置初始化完成标识
                    }
                } finally {//恢复标识
                    cellsBusy = 0;
                }
                if (init)
                    break;
            }
            //竞争激烈，其它线程占据 cell 数组，直接累加在 base 变量中
            else if (U.compareAndSwapLong(this, BASECOUNT, v = baseCount, v + x))
                break;                          // Fall back on using base
        }
    }
```
##### transfer() 扩容阶段:
```
回到 addCount(long x, int check)。判断是否需要扩容，也就是当更新后的键值对总数 baseCount >= 阈值 sizeCtl 时，进行rehash，这里面会有两个逻辑。

1.如果当前正在处于扩容阶段，则当前线程会加入并且协助扩容
2.如果当前没有在扩容，则直接触发扩容操作
```
```
private final void addCount(long x, int check) {
　　　　　........if (check >= 0) {//如果 binCount>=0，标识需要检查扩容
            Node<K,V>[] tab, nt; int n, sc;
            //s 标识集合大小，如果集合大小大于或等于扩容阈值（默认值的 0.75）
            //并且 table 不为空并且 table 的长度小于最大容量
            while (s >= (long)(sc = sizeCtl) && (tab = table) != null &&
                    (n = tab.length) < MAXIMUM_CAPACITY) {
                //这里是生成一个唯一的扩容戳，这个是干嘛用的呢？
                int rs = resizeStamp(n);
                if (sc < 0) {//sc<0，也就是 sizeCtl<0，说明已经有别的线程正在扩容了
                    // 这 5 个条件只要有一个条件为 true，说明当前线程不能帮助进行此次的扩容，直接跳出循环
                    // sc >>> RESIZE_STAMP_SHIFT!=rs 表示比较高 RESIZE_STAMP_BITS 位生成戳和 rs 是否相等，相同
                    // sc=rs+1 表示扩容结束
                    // sc==rs+MAX_RESIZERS 表示帮助线程线程已经达到最大值了
                    // nt=nextTable -> 表示扩容已经结束
                    // transferIndex<=0 表示所有的 transfer 任务都被领取完了，
                    // 没有剩余的hash 桶来给自己自己好这个线程来做 transfer
                    if ((sc >>> RESIZE_STAMP_SHIFT) != rs || sc == rs + 1 ||
                            sc == rs + MAX_RESIZERS || (nt = nextTable) == null ||
                            transferIndex <= 0)
                        break;
                    //当前线程尝试帮助此次扩容，如果成功，则调用 transfer
                    if (U.compareAndSwapInt(this, SIZECTL, sc, sc + 1))
                        transfer(tab, nt);
                }
                // 如果当前没有在扩容，那么 rs 肯定是一个正数，
                // 通过 rs<<RESIZE_STAMP_SHIFT 将 sc 设置为一个负数，+2 表示有一个线程在执行扩容
                else if (U.compareAndSwapInt(this, SIZECTL, sc,
                        (rs << RESIZE_STAMP_SHIFT) + 2))
                    transfer(tab, null);
                s = sumCount();// 重新计数，判断是否需要开启下一轮扩容
            }
        }
    }
```

##### resizeStamp:
```
　　这块逻辑要理解起来，也有一点复杂。resizeStamp 用来生成一个和扩容有关的扩容戳，具体有什么作用呢？我们基于它的实现来做一个分析
```

```
static final int resizeStamp(int n) {
　　return Integer.numberOfLeadingZeros(n) | (1 << (RESIZE_STAMP_BITS - 1));
}
```
```
　　Integer.numberOfLeadingZeros 这个方法是返回无符号整数 n 最高位非 0 位前面的 0 的个数，
　　比如 10 的二进制是 
　　0000 0000 0000 0000 0000 0000 0000 1010，那么这个方法返回的值就是 28

　　根据 resizeStamp 的运算逻辑，我们来推演一下，假如 n=16，那么 resizeStamp(16)=32796。
　　转化为二进制是 
　　[0000 0000 0000 0000 1000 0000 0001 1100]

　　接着再来看,当第一个线程尝试进行扩容的时候，会执行下面这段代码：
　　U.compareAndSwapInt(this, SIZECTL, sc, (rs << RESIZE_STAMP_SHIFT) + 2)

　　rs 左移 16 位，相当于原本的二进制低位变成了高位 
　　1000 0000 0001 1100 0000 0000 0000 0000

　　然后再+2 =
　　1000 0000 0001 1100 0000 0000 0000 0000+10=
　　1000 0000 0001 1100 0000 0000 0000 0010

　　 高 RESIZE_STAMP_BITS  16 位代表扩容的标记、低 RESIZE_STAMP_BITS 16 位代表并行扩容的线程数。这样来存储有什么好处呢？

    首先在 CHM 中是支持并发扩容的，也就是说如果当前的数组需要进行扩容操作，
    可以由多个线程来共同负责，这块后续会单独讲
    可以保证每次扩容都生成唯一的生成戳，每次新的扩容，都有一个不同的 n，
    这个生成戳就是根据 n 来计算出来的一个数字，n 不同，这个数字也不同

　　第一个线程尝试扩容的时候，为什么是+2 ？

　　因为 1 表示初始化，2 表示一个线程在执行扩容，而且对 sizeCtl 的操作都是基于位运算的
　　，所以不会关心它本身的数值是多少，只关心它在二进制上的数值，而 sc + 1 会在低 16 位上加 1。

　　扩容是 ConcurrentHashMap 的精华之一，扩容操作的核心在于数据的转移，在单线程环境下数据的转移很简单，无非就是把旧数组中的数据迁移到新的数组。但是这在多线程环境下，在扩容的时候其他线程也可能正在添加元素，这时又触发了扩容怎么办？
　　可能大家想到的第一个解决方案是加互斥锁，把转移过程锁住，虽然是可行的解决方案，但是会带来较大的性能开销。
　　因为互斥锁会导致所有访问临界区的线程陷入到阻塞状态，持有锁的线程耗时越长，其他竞争线程就会一直被阻塞，导致吞吐量较低。
　　而且还可能导致死锁。而 ConcurrentHashMap 并没有直接加锁，而是采用 CAS 实现无锁的并发同步策略，
　　最精华的部分是它可以利用多线程来进行协同扩容简单来说，
　　它把 Node 数组当作多个线程之间共享的任务队列，
　　然后通过维护一个指针来划分每个线程锁负责的区间，
　　每个线程通过区间逆向遍历来实现扩容
　　，一个已经迁移完的bucket会被替换为一个ForwardingNode节点，
　　标记当前bucket已经被其他线程迁移完了。接下来分析一下它的源码实现

    fwd:这个类是个标识类，用于指向新表用的，其他线程遇到这个类会主动跳过这个类，
    因为这个类要么就是扩容迁移正在进行，要么就是已经完成扩容迁移，也就是这个类要保证线程安全，再进行操作。
    advance:这个变量是用于提示代码是否进行推进处理，也就是当前桶处理完，处理下一个桶的标识
    finishing:这个变量用于提示扩容是否结束用的
```

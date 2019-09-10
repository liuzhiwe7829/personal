package pattern.create.singleton;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1020:59
 * 双重加锁
 */
public class Singleton04 {

    // 和饿汉模式相比，这边不需要先实例化出来
    // 注意这里的 volatile，使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行
    private volatile  static Singleton04 uniqueInstance ;

    private Singleton04(){

    }
    public  static Singleton04 newInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton04.class){
                //这一次判断是必须的，不然会有并发问题
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton04();
                }
            }
        }
        return  uniqueInstance;
    }

}

package pattern.create.singleton;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1020:59
 * 懒汉式:线程安全
 * 有延迟加载：不是在类加载的时候就创建了，而是在调用newStance()的时候才会创建
 * 一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，即使 uniqueInstance
 * 已经被实例化了。这会让线程阻塞时间过长，因此该方法有性能问题，
 */
public class Singleton02 {

    private static Singleton02 uniqueInstance;

    private Singleton02(){

    }
    public  static  synchronized  Singleton02 newInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Singleton02();
        return  uniqueInstance;
    }

}

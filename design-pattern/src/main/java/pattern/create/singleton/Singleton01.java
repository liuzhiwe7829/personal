package pattern.create.singleton;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1020:59
 * 懒汉式:线程不安全
 * 有延迟加载：不是在类加载的时候就创建了，而是在调用newStance()的时候才会创建
 */
public class Singleton01 {

    private static Singleton01 uniqueInstance;

    private Singleton01(){

    }
    public  static Singleton01 newInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Singleton01();
        return  uniqueInstance;
    }

}

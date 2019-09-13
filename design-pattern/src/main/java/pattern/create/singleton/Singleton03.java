package pattern.create.singleton;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1020:59
 * 饿汉式:线程安全
 */
public class Singleton03 {

    private static Singleton03 uniqueInstance = new Singleton03();

    private Singleton03(){

    }
    public  static   Singleton03 newInstance(){
        return  uniqueInstance;
    }

}

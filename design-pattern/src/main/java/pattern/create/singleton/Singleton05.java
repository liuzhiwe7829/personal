package pattern.create.singleton;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1020:59
 * 静态内部类实现
 */
public class Singleton05 {

    private Singleton05(){

    }
    // 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法 的特性
    // 很多人都会把这个嵌套类说成是静态内部类，严格地说，内部类和嵌套类是不一样的，它们能访问的外部类权限也是不一样的。

    private  static  class  Holder{
        private static  final  Singleton05 unqueInstance = new Singleton05();
    }
    public  static  Singleton05 newInstance(){
        return Holder.unqueInstance;
    }
}

package pattern.structure.proxy.tankDemo;

/**
 * @author zhiwei.liu003
 * @date 2019/9/923:47
 */
public class Client {

    /**
     * 两个代理对象内部都有被代理对象 target 实现的接口的引用
     * 两个代理对象都实现了被代理对象 target 实现的接口
     * @param args
     */
    public static void main(String[] args) {
        //先记录日志在记录时间
        Movable target = new TankTimeProxy(new TankLogProxy(new Tank()));
//        Movable target = new TankLogProxy(new TankTimeProxy(new Tank()));

        target.move();
    }
}

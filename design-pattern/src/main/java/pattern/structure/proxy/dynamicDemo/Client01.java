package pattern.structure.proxy.dynamicDemo;


/**
 * @author zhiwei.liu003
 * @date 2019/9/1017:52
 */
public class Client01 {
    public  static void main(String[] args) throws  Exception{
        Movable tank = new Tank();
        MyInvocationHandler timeHandler = new MyTimeInvocationHandler(tank);
        Movable tankProxy = (Movable) MyProxy.newProxyInstance(Movable.class, timeHandler); // 传入类的.class即可
        tankProxy.move();

        System.out.println("--------------------");

        Flyable plane = new Plane();
        timeHandler = new MyTimeInvocationHandler(plane);
        Flyable planeProxy = (Flyable) MyProxy.newProxyInstance(Flyable.class, timeHandler);
        planeProxy.fly();

    }
}

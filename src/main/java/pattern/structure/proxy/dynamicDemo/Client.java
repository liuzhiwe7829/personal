package pattern.structure.proxy.dynamicDemo;

import java.lang.reflect.Proxy;

/**
 * @author zhiwei.liu003
 * @date 2019/9/100:17
 */
public class Client {
    public  static  void main (String [] args){
        Movable tank = new Tank();
        MyTimeProxyInvocationHandler myTimeProxyInvocationHandler = new MyTimeProxyInvocationHandler(tank);
        Movable tankProxy = (Movable) Proxy.newProxyInstance(
                tank.getClass().getClassLoader(),
                tank.getClass().getInterfaces(),
                myTimeProxyInvocationHandler
        );
        tankProxy.move();
        System.out.println("-------------------------");

        Flyable plane = new Plane();
        myTimeProxyInvocationHandler = new MyTimeProxyInvocationHandler(plane);
        Flyable planeProxy =(Flyable) Proxy.newProxyInstance(
                plane.getClass().getClassLoader(),
                plane.getClass().getInterfaces(),
                myTimeProxyInvocationHandler
        );
        planeProxy.fly();
        System.out.println("------------------");
    }
}

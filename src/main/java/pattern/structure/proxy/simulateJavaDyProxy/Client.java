package pattern.structure.proxy.simulateJavaDyProxy;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1016:46
 */
public class Client {

    public  static  void main(String[] args) throws  Exception{
        Movable tank = new Tank();
        Movable tankProxy = (Movable) MyProxy.newProxyInstance();
        tankProxy.move();
    }
}

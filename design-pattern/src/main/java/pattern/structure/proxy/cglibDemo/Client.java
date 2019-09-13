package pattern.structure.proxy.cglibDemo;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1015:41
 */
public class Client {
    public static void main(String[] args){
        Tank proxyTank = new MyCglibFactory(new Tank()).myCglibCreator();
        proxyTank.move();
    }
}

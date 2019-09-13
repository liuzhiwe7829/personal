package pattern.structure.proxy.simulateJavaDyProxy;

import java.util.Random;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1016:23
 */
public class Tank  implements  Movable{
    @Override
    public void move() {
        System.out.println("Tank Moving -----------");
        try{
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

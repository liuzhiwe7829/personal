package pattern.structure.proxy.cglibDemo;

import java.util.Random;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1015:29
 */
public class Tank {

    public void move() {
        System.out.println("Tank Moving -----");
        try{
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

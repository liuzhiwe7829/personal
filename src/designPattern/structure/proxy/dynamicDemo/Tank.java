package designPattern.structure.proxy.dynamicDemo;

import java.util.Random;

/**
 * @author zhiwei.liu003
 * @date 2019/9/100:12
 */
public class Tank implements  Movable {
    @Override
    public void move() {
        System.out.println("Tank is moving --------");
        try{
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

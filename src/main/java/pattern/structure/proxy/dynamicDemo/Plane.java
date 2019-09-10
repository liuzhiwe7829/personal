package pattern.structure.proxy.dynamicDemo;

import java.util.Random;

/**
 * @author zhiwei.liu003
 * @date 2019/9/100:09
 */
public class Plane implements  Flyable {
    @Override
    public void fly() {
        System.out.println("Plane Flying----");
        try{
            Thread.sleep(new Random().nextInt(5000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

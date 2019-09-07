package designPattern.adapter01.turkey;

/**
 * @author zhiwei.liu003
 * @date 2019/9/710:35
 */

/**
 * 野火鸡
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Go Go!");
    }

    @Override
    public void fly() {
        System.out.println("I am Flying a short distance!");
    }
}

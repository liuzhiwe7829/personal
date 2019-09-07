package designPattern.adapter01;

/**
 * @author zhiwei.liu003
 * @date 2019/9/710:33
 */

import designPattern.adapter01.adapter.TurkeyAdapter01;
import designPattern.adapter01.duck.Duck;
import designPattern.adapter01.turkey.WildTurkey;

/**
 * 让火鸡像鸭子一样行为，飞，叫
 */
public class AdapterTest {
    public static void main(String[] args) {
        WildTurkey turkey = new WildTurkey();
//        Duck duck = new TurkeyAdapter(turkey);
        Duck duck = new TurkeyAdapter01(turkey);
        duck.quack();//看似鸭子，其实内置火鸡
        duck.fly();
    }

}

package designPattern.structure.decorator.orderDemo.decorator;

import designPattern.structure.decorator.orderDemo.compenent.Drink;

/**
 * @author zhiwei.liu003
 * @date 2019/9/812:33
 */
public class Choloclate extends Decortor {
    public Choloclate(Drink drink) {
        super(drink);
        super.setDescription("Chocolate");
        super.setPrice(1);
    }
}

package pattern.structure.decorator.orderDemo.decorator;

import designPattern.structure.decorator.orderDemo.compenent.Drink;

/**
 * @author zhiwei.liu003
 * @date 2019/9/812:33
 */
public class Milk extends Decortor{
    public Milk(Drink drink) {
            super(drink);
            super.setDescription("Milk");
            super.setPrice(3);
    }
}

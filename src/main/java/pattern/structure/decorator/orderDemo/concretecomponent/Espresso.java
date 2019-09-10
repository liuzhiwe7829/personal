package pattern.structure.decorator.orderDemo.concretecomponent;

import designPattern.structure.decorator.orderDemo.compenent.Drink;

/**
 * @author zhiwei.liu003
 * @date 2019/9/812:26
 */
public class Espresso extends Drink {
    public Espresso() {
        super.setDescription("Espresso");
        super.setPrice(4);
    }

    @Override
    public double cost() {
        return getPrice();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "-" + cost();
    }
}

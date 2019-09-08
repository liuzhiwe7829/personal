package designPattern.structure.decorator.orderDemo.concretecomponent;

import designPattern.structure.decorator.orderDemo.compenent.Drink;

/**
 * @author zhiwei.liu003
 * @date 2019/9/812:26
 */
public class Decaf extends Drink {
    public Decaf() {
        super.setDescription("Decak");
        super.setPrice(3);
    }

    @Override
    public double cost() {
        //super.getPrice();这个是父类的价格
        return getPrice();
    }

    /**
     * 重写getter 加上自己花费
     * @return
     */
    @Override
    public String getDescription() {
        return super.getDescription() + "-" + cost();
    }
}

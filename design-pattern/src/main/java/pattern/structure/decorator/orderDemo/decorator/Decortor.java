package pattern.structure.decorator.orderDemo.decorator;


import pattern.structure.decorator.orderDemo.compenent.Drink;

/**
 * @author zhiwei.liu003
 * @date 2019/9/812:33
 * 装饰者超类
 */
public class Decortor extends Drink {
    /**
     * 该引用可以是单品，也可是被包装过的类型，所以使用超类对象
     * 此处为被包装的单品
     */
    private Drink drink;

    public Decortor(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        //自己的价格和被包装单品的价格
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "-" + super.getPrice()
                + " && " + drink.getDescription();
    }
}

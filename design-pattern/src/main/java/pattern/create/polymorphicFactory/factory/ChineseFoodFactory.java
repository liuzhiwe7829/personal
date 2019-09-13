package pattern.create.polymorphicFactory.factory;


import pattern.create.polymorphicFactory.products.ChineseFoodA;
import pattern.create.polymorphicFactory.products.ChineseFoodB;
import pattern.create.polymorphicFactory.products.Food;

/**
 * @author zhiwei.liu003
 * @date 2019/9/823:49
 */
public class ChineseFoodFactory implements FoodFactory {
    @Override
    public Food makeFodd(String name) {
        if (name.equals("A")) {
            return new ChineseFoodA();
        } else if (name.equals("B")) {
            return new ChineseFoodB();
        } else {
            return null;
        }
    }
}

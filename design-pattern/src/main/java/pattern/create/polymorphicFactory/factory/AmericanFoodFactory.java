package pattern.create.polymorphicFactory.factory;


import pattern.create.polymorphicFactory.products.AmericanFoodA;
import pattern.create.polymorphicFactory.products.AmericanFoodB;
import pattern.create.polymorphicFactory.products.Food;

/**
 * @author zhiwei.liu003
 * @date 2019/9/823:47
 */
public class AmericanFoodFactory implements FoodFactory {
    @Override
    public Food makeFodd(String name) {
        if (name.equals("A")){
            return new AmericanFoodA();
        } else if (name.equals("B")) {
            return new AmericanFoodB();
        } else {
            return null;
        }
    }
}

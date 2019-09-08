package designPattern.create.polymorphicFactory.factory;

import com.ouyang.test.A;
import designPattern.create.polymorphicFactory.products.*;

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

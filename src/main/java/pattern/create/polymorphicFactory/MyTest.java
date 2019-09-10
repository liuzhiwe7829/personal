package pattern.create.polymorphicFactory;

import designPattern.create.polymorphicFactory.factory.ChineseFoodFactory;
import designPattern.create.polymorphicFactory.factory.FoodFactory;
import designPattern.create.polymorphicFactory.products.Food;

/**
 * @author zhiwei.liu003
 * @date 2019/9/823:55
 */
public class MyTest {
    public static  void  main(String[] args){
        //选择一个具体的工厂
        FoodFactory factory = new ChineseFoodFactory();

        //由第一步的工厂产生具体的对象，不同的工厂造出不同的对象
        Food food = factory.makeFodd("A");
    }
}

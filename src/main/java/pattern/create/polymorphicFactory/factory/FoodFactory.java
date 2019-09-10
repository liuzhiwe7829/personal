package pattern.create.polymorphicFactory.factory;


import pattern.create.polymorphicFactory.products.Food;

/**
 * @author zhiwei.liu003
 * @date 2019/9/823:47
 * 抽象工厂
 */
public interface FoodFactory {
    Food makeFodd(String name);
}

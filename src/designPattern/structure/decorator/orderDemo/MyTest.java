package designPattern.structure.decorator.orderDemo;

import designPattern.structure.decorator.orderDemo.compenent.Drink;
import designPattern.structure.decorator.orderDemo.concretecomponent.Decaf;
import designPattern.structure.decorator.orderDemo.decorator.Choloclate;
import designPattern.structure.decorator.orderDemo.decorator.Milk;

/**
 * @author zhiwei.liu003
 * @date 2019/9/812:26
 */
public class MyTest {
    public static void main(String[] args){
        //单品
        Drink order = new Decaf();
        System.out.println("order description : "+order.getDescription());
        System.out.println("order price :"+order.cost());

        System.out.println("--------------加料-----------");

        order = new Milk(order) ;
//        order = new Choloclate(order);
//        //双份巧克力
//        order = new Choloclate(order);
        System.out.println("order description : "+order.getDescription());
        System.out.println("order price :"+order.cost());
    }

}

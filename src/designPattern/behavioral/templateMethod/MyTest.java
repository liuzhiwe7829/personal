package designPattern.behavioral.templateMethod;

/**
 * @author zhiwei.liu003
 * @date 2019/9/919:51
 */
public class MyTest {
    public static void main (String[] args){
        Shopping shoesShopping = new ShoesShopping();
        shoesShopping.buyGoods();


        System.out.println("----------------华丽的分割线---------------");
        Shopping clothesShopping = new ClothesShopping();
        clothesShopping.buyGoods();
    }
}

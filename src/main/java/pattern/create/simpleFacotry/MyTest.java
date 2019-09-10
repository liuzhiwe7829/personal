package pattern.create.simpleFacotry;

/**
 * @author zhiwei.liu003
 * @date 2019/9/823:24
 */
public class MyTest {
    public static  void main(String[] args){
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        //do something with product
    }
}

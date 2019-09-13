package pattern.create.simpleFacotry;

/**
 * @author zhiwei.liu003
 * @date 2019/9/823:22
 */
public class SimpleFactory {

    //
    public  Product createProduct(int type){
        if(type == 1){
            return  new ConcreteProduct1();
        }else if (type == 2){
            return  new ConcreteProduct2();
        }
        return  new ConcreteProduct();
    }
}

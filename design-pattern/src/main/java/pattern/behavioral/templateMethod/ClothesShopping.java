package pattern.behavioral.templateMethod;

/**
 * @author zhiwei.liu003
 * @date 2019/9/919:49
 */
public class ClothesShopping extends Shopping {
    @Override
    public void buy() {
        System.out.println("买海澜之家男装");
    }
    @Override
    public  void pay(){
        System.out.println("使用支付宝");
    }
}

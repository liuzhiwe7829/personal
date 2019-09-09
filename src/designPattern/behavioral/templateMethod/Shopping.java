package designPattern.behavioral.templateMethod;

/**
 * @author zhiwei.liu003
 * @date 2019/9/919:44
 */
public abstract class Shopping {
    public void buyGoods() {
        //固定方法，子类不能重写
        userLogin();
        //抽象方法，子类必须实现
        buy();
        //钩子方法（hook）,子类可以重写
        pay();
    }

    public void pay() {
        System.out.println("银联支付");
    }

    public abstract void buy();

    public final void userLogin() {
        System.out.println("用户登录");
    }
}

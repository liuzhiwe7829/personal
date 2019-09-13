package pattern.structure.decorator.orderDemo.compenent;

/**
 * @author zhiwei.liu003
 * @date 2019/9/812:33
 * Component 的超类
 * 单品和装饰者都是要继承自这个类
 */
public abstract  class Drink {


    //一开始没有描述
    private String description = "";
    //初始价格0
    private double price = 0;

    /**
     * 抽象方法
     * 1、如果是单品 即价值
     * 2、如果是装饰者还要加上装饰者自己的价格
     * @return
     */
    public abstract  double cost();

    //setter getter

    public String getDescription(){
        return description;
    }
    public  double getPrice(){
        return  price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

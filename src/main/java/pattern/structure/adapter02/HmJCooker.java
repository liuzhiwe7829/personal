package pattern.structure.adapter02;

/**
 * @author zhiwei.liu003
 * @date 2019/9/712:18
 */

/**
 * 黄焖鸡厨师
 */
public class HmJCooker implements  ICooker{

    @Override
    public String cook() {
        return "做鸡";
    }
}

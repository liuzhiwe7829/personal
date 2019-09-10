package pattern.structure.adapter01.adapter;

import designPattern.adapter01.duck.Duck;
import designPattern.adapter01.turkey.Turkey;

/**
 * @author zhiwei.liu003
 * @date 2019/9/710:26
 */

/**
 * 对象适配器
 * 表现为鸭子（目标target）,实质是火鸡（被适配者）
 */
public class TurkeyAdapter  implements Duck {
    private Turkey turkey ;//对象行必须要组合，被适配者，要有适配者的引用

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }
    @Override
    public void quack() {
    turkey.gobble();//表现为quack,内部调用turkey.gobble()
    }

    @Override
    public void fly() {
        //火鸡翅膀短，多飞几次，让火鸡更像鸭子
        for (int i = 0 ; i < 6; i++){
            turkey.fly();
        }
    }
}

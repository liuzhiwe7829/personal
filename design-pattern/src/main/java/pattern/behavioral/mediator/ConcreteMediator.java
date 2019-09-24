package pattern.behavioral.mediator;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2422:15
 */
public class ConcreteMediator extends SmartMediator {
    public ConcreteMediator(SmartDevice db, SmartDevice md, SmartDevice cd) {
        super(db, md, cd);
    }

    @Override
    public void music(String instruction) {
        //音乐被唤醒后，使其他设备沮洳准备状态
        //调用窗帘的准备方法
        cd.readyState(instruction);
        //调用洗浴设备的准备方法
        bd.readyState(instruction);

    }

    @Override
    public void curtain(String instruction) {
        md.readyState(instruction);
        bd.readyState(instruction);
    }

    @Override
    public void bath(String instruction) {
        cd.readyState(instruction);
        md.readyState(instruction);
    }
}

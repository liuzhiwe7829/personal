package pattern.behavioral.mediator;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2422:07
 * 抽象中介者（中介设备）
 */
public abstract class SmartMediator {
    SmartDevice bd;
    SmartDevice md;
    SmartDevice cd;

    public SmartMediator(SmartDevice bd, SmartDevice md, SmartDevice cd) {
        super();
        this.bd = bd;
        this.md = md;
        this.cd = cd;
    }

    public abstract void music(String instruction);

    public abstract void curtain(String instruction);

    public abstract void bath(String instruction);
}

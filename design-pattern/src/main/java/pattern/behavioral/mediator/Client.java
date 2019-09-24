package pattern.behavioral.mediator;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2422:20
 */
public class Client {
    public static void main(String[] args){
        SmartDevice bd = new BathDevice();
        SmartDevice cd = new CurtainDevice();
        SmartDevice md = new MusicDevice();
        SmartMediator sm = new ConcreteMediator(bd,cd,md);
        //开启窗帘
        cd.operateDevice("open",sm);
        //关闭音乐
        md.operateDevice("cloese",sm);
    }
}

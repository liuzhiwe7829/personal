package pattern.behavioral.mediator;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2422:06
 * 窗帘设备
 */
public class CurtainDevice  extends SmartDevice{
    @Override
    public void readyState(String instruction) {
        System.out.println("窗帘已"+instruction);
    }
    @Override
    public  void operateDevice(String instruction, SmartMediator mediator){
        System.out.println("窗帘设备正在"+instruction);
    }
}

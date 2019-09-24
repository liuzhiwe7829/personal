package pattern.behavioral.mediator;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2422:03
 * 抽象类（只能设备）
 */
public abstract  class SmartDevice {

    /**
     * 相关设备打开之后 使其进入准备状态
     * @param instruction
     */
    public abstract void readyState(String instruction);
    /**
     * 操作设备
     */
    public  abstract  void operateDevice(String instruction,SmartMediator mediator);
}

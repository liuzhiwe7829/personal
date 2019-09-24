package pattern.behavioral.mediator;

public class BathDevice extends SmartDevice {

    @Override
	public void operateDevice(String instruction, SmartMediator mediator) {
        System.out.println("洗浴设备" + instruction);
        mediator.bath(instruction);
    }

    @Override
	public void readyState(String instruction) {
        System.out.println("洗浴设备正在准备" + instruction);
    }

}

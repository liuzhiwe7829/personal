package pattern.create.abstractFactory.computerDemo.factory;


import designPattern.create.abstractFactory.computerDemo.product.AmdCPU;
import designPattern.create.abstractFactory.computerDemo.product.AmdMainBoard;
import designPattern.create.abstractFactory.computerDemo.product.CPU;
import designPattern.create.abstractFactory.computerDemo.product.MainBoard;

public class AmdFactory implements PCFactory{

    @Override
    public CPU makeCPU() {
        return new AmdCPU();
    }

    @Override
    public MainBoard makeMB() {
        return new AmdMainBoard();
    }
}

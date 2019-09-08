package designPattern.create.abstractFactory.computerDemo.factory;


import designPattern.create.abstractFactory.computerDemo.product.CPU;
import designPattern.create.abstractFactory.computerDemo.product.IntelCPU;
import designPattern.create.abstractFactory.computerDemo.product.IntelMainBoard;
import designPattern.create.abstractFactory.computerDemo.product.MainBoard;

public class IntelFactory implements PCFactory {

    @Override
    public CPU makeCPU() {
        return new IntelCPU();
    }

    @Override
    public MainBoard makeMB() {
        return new IntelMainBoard();
    }
}

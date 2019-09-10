package pattern.create.abstractFactory.computerDemo.factory;


import pattern.create.abstractFactory.computerDemo.product.AmdCPU;
import pattern.create.abstractFactory.computerDemo.product.AmdMainBoard;
import pattern.create.abstractFactory.computerDemo.product.CPU;
import pattern.create.abstractFactory.computerDemo.product.MainBoard;

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

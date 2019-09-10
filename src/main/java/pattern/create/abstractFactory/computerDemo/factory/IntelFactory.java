package pattern.create.abstractFactory.computerDemo.factory;


import pattern.create.abstractFactory.computerDemo.product.CPU;
import pattern.create.abstractFactory.computerDemo.product.IntelCPU;
import pattern.create.abstractFactory.computerDemo.product.IntelMainBoard;
import pattern.create.abstractFactory.computerDemo.product.MainBoard;

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

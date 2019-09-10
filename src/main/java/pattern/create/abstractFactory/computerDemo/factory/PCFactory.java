package pattern.create.abstractFactory.computerDemo.factory;


import pattern.create.abstractFactory.computerDemo.product.CPU;
import pattern.create.abstractFactory.computerDemo.product.MainBoard;

public interface PCFactory {

    CPU makeCPU();
    MainBoard makeMB();
    // HardDisk makeHD();
}

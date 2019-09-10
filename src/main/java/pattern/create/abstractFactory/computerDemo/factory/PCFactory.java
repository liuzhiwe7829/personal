package pattern.create.abstractFactory.computerDemo.factory;


import designPattern.create.abstractFactory.computerDemo.product.CPU;
import designPattern.create.abstractFactory.computerDemo.product.MainBoard;

public interface PCFactory {

    CPU makeCPU();
    MainBoard makeMB();
    // HardDisk makeHD();
}

package pattern.create.abstractFactory.computerDemo.computer;

import pattern.create.abstractFactory.computerDemo.product.CPU;
import pattern.create.abstractFactory.computerDemo.product.MainBoard;

/**
 * @author zhiwei.liu003
 * @date 2019/9/90:13
 */
public class Computer {

    private CPU cpu;

    private MainBoard mainBoard;

    public Computer(CPU cpu, MainBoard mainBoard) {
        this.cpu = cpu;
        this.mainBoard = mainBoard;
    }
}
package designPattern.create.abstractFactory.computerDemo;


import designPattern.create.abstractFactory.computerDemo.computer.Computer;
import designPattern.create.abstractFactory.computerDemo.factory.AmdFactory;
import designPattern.create.abstractFactory.computerDemo.factory.PCFactory;
import designPattern.create.abstractFactory.computerDemo.product.CPU;
import designPattern.create.abstractFactory.computerDemo.product.MainBoard;

public class MyTest {
    public static void main(String[] args){
        // 第一步就要选定一个“大厂”
        PCFactory cf = new AmdFactory();
        // 从这个大厂造 CPU
        CPU cpu = cf.makeCPU();
        // 从这个大厂造主板
        MainBoard board = cf.makeMB();

        //... 从这个大厂造硬盘。等等

        // 将同一个厂子出来的 CPU、主板、硬盘组装在一起
        Computer computer = new Computer(cpu, board);
    }
}

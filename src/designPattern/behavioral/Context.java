package designPattern.behavioral;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:04
 */

/**
 * 使用了某种策略的类，实现了Strategy接口的实现策略类
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1,num2);
    }
}

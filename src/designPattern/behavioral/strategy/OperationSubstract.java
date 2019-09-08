package designPattern.behavioral.strategy;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:05
 */
public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

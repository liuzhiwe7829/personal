package designPattern.behavioral.strategy;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:04
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

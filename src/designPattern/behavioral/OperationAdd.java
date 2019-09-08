package designPattern.behavioral;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:04
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

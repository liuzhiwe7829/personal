package designPattern.behavioral;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:06
 */
public class Test01 {
    public static void main (String[] agrs){
        Context context = new Context(new OperationAdd());

        System.out.println("加法:"+ context.executeStrategy(10,3));

        context = new Context(new OperationMultiply());

        System.out.println("*:"+context.executeStrategy(10,3));

        context = new Context(new OperationSubstract());

        System.out.println("-:"+context.executeStrategy(10,3));
    }

}

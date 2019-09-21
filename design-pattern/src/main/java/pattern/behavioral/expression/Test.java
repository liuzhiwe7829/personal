package pattern.behavioral.expression;

import java.sql.SQLOutput;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2116:33
 */
public class Test {
    public static void main(String[] args){
        Context context = new Context();
        TerminalExpression a = new TerminalExpression("a");
        TerminalExpression b = new TerminalExpression("b");
        TerminalExpression c = new TerminalExpression("c");
        context.add(a,4);
        context.add(b,8);
        context.add(c,2);
        System.out.println(new MinusOperation(new PlusOperation(a,b),c).interpreter(context));
    }
}

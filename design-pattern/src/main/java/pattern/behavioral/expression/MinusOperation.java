package pattern.behavioral.expression;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2116:10
 * 减法表达式实现类
 */
public class MinusOperation extends NonTerminalExpressino {
    public MinusOperation(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public int interpreter(Context context) {
        return this.e1.interpreter(context) - this.e2.interpreter(context);
    }
}

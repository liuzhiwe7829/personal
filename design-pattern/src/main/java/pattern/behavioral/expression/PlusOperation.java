package pattern.behavioral.expression;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2116:16
 */
public class PlusOperation extends NonTerminalExpressino {
    public PlusOperation(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * 两个表达式相加
     * @param context
     * @return
     */
    @Override
    public int interpreter(Context context) {
        return this.e1.interpreter(context) + this.e2.interpreter(context);
    }
}

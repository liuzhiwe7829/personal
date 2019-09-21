package pattern.behavioral.expression;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2116:08
 */
public abstract  class NonTerminalExpressino  implements Expression{
    Expression e1,e2;
    public NonTerminalExpressino(Expression e1,Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }
}

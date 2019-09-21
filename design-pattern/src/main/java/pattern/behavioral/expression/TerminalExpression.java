package pattern.behavioral.expression;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2116:14
 * 终结符表达式 本例子中用来存放数字，或者带边数字的字符
 */
public class TerminalExpression  implements Expression{
    String variable;
    public  TerminalExpression(String variable){
        this.variable = variable;
    }
    @Override
    public int interpreter(Context context) {
       Integer lookup =   context.lookup(this);
       if(lookup == null) {
           return  Integer.valueOf(variable);
       }
        return lookup;
    }
}

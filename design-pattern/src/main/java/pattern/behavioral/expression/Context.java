package pattern.behavioral.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2115:57
 */
public class Context {
    private Map<Expression, Integer> map = new HashMap<>();

    //定义变量
    public void add(Expression s, Integer value) {
        map.put(s, value);
    }

    /**
     * 将变量转化为数字
     */
    public int lookup(Expression s) {
        return map.get(s);
    }

    /**
     * 构建语法树
     */
    public static Expression build(String str) {
        //利用栈实现
        Stack<Expression> objects = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+') {
                //出栈
                Expression pop = objects.pop();
                //将运算结果入栈
                objects.push(new PlusOperation(pop, new TerminalExpression(String.valueOf(str.charAt(++i)))));
            } else if (c == '-') {
                //出栈
                Expression pop = objects.pop();
                //将运算结果入栈
                objects.push(new MinusOperation(pop, new TerminalExpression(String.valueOf(str.charAt(++i)))));
            } else {
                //遇到非终结符直接入栈
                objects.push(new TerminalExpression(String.valueOf(str.charAt(i))));
            }
//            switch (c) {
//                case '+':
//                    //出栈
//                    Expression pop = objects.pop();
//                    //将运算结果入栈
//                    objects.push(new PlusOperation(pop, new TerminalExpression(String.valueOf(str.charAt(++i)))));
//                    break;
//                case '-':
//                    //出栈
//                    pop = objects.pop();
//                    //将运算结果入栈
//                    objects.push(new MinusOperation(pop, new TerminalExpression(String.valueOf(str.charAt(++i)))));
//                    break;
//                default:
//                    //遇到非终结符直接入栈
//                    objects.push(new TerminalExpression(String.valueOf(str.charAt(i))));
//                    throw new IllegalStateException("Unexpected value: " + c);
//        }
        }
        //把最后的栈顶元素返回
        return objects.pop();
    }

}

package pattern.behavioral.expression;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2115:56
 * 解释器接口
 */
public interface Expression {
    int interpreter(Context context);
}

package pattern.behavioral.visitor;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2212:10
 * visitor抽象类 果农
 */
public abstract class Farmer {
    public abstract void plant(AppleHole hole);

    public abstract void plant(OrangeHole hole);
}

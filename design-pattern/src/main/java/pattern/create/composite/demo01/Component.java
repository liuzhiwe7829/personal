package pattern.create.composite.demo01;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1317:36
 */
public abstract class Component {
    //所有节点都有值
    int val;

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void show();
}

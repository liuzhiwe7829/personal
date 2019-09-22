package pattern.behavioral.visitor;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2212:12
 * 抽象元素
 */
public interface Hole {
    /**
     * 表示接受果农的访问
     * @param farmer
     */
    void accept(Farmer farmer);
}

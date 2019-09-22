package pattern.behavioral.visitor;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2212:13
 * 橘子树坑
 */
public class OrangeHole implements Hole {
    private String index;

    public OrangeHole(String index) {
        this.index = index;
    }

    @Override
    public void accept(Farmer farmer) {
        farmer.plant(this);
    }

    public String getIndex() {
        return this.index;
    }
}

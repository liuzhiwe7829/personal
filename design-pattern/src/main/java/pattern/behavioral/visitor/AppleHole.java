package pattern.behavioral.visitor;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2212:13
 * 苹果树坑
 */
public class AppleHole implements Hole {
    private String index;

    public AppleHole(String index) {
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

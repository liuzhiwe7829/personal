package pattern.structure.bridge.colorDemo.color;

/**
 * @author zhiwei.liu003
 * @date 2019/9/716:20
 */
public class RedPen implements  ColorAPI {
    @Override
    public void draw(String name) {
        System.out.println("红笔画:"+name);
    }
}

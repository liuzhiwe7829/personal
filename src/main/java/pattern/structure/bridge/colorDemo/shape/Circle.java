package pattern.structure.bridge.colorDemo.shape;


import pattern.structure.bridge.colorDemo.color.ColorAPI;

/**
 * @author zhiwei.liu003
 * @date 2019/9/716:27
 */
public class Circle extends Shape {
    private String name;

    public Circle(String name, ColorAPI colorAPI) {
        super(colorAPI);
        this.name = name;
    }

    @Override
    public void dw() {
        colorAPI.draw(name);
    }
}

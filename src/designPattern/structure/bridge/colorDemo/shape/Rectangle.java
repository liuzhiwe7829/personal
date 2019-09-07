package designPattern.structure.bridge.colorDemo.shape;

import designPattern.structure.bridge.colorDemo.color.ColorAPI;

/**
 * @author zhiwei.liu003
 * @date 2019/9/716:29
 */
public class Rectangle extends Shape{

    private String name;

    public Rectangle(String name, ColorAPI colorAPI) {
        super(colorAPI);
        this.name = name;
    }

    @Override
    public void dw() {
        colorAPI.draw(name);
    }
}

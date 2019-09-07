package designPattern.structure.bridge.colorDemo.shape;

import designPattern.structure.bridge.colorDemo.color.ColorAPI;

/**
 * @author zhiwei.liu003
 * @date 2019/9/716:17
 */
public abstract class Shape {
    protected ColorAPI colorAPI;//此父类必须有，

    protected Shape(ColorAPI colorAPI) {
        this.colorAPI = colorAPI;
    }

    public abstract void dw();//color
}

package pattern.structure.bridge.colorDemo;

import designPattern.structure.bridge.colorDemo.color.BluePen;
import designPattern.structure.bridge.colorDemo.color.RedPen;
import designPattern.structure.bridge.colorDemo.shape.Circle;
import designPattern.structure.bridge.colorDemo.shape.Rectangle;
import designPattern.structure.bridge.colorDemo.shape.Shape;

/**
 * @author zhiwei.liu003
 * @date 2019/9/716:36
 */
//桥接模式：解决排列组合导致组合类巨多的问题
public class BridgeTest {
    public static  void main(String[] args){
        Shape blueRectangle = new Rectangle("长方形",new BluePen());
        blueRectangle.dw();

        Shape redCircle = new Circle("圆",new RedPen());
        redCircle.dw();
    }
}

package designPattern.structure.bridge.colorDemo.color;

/**
 * @author zhiwei.liu003
 * @date 2019/9/716:20
 */
public class GreenPen implements  ColorAPI {
    @Override
    public void draw(String name) {
        System.out.println("绿笔画:"+name);
    }
}

package demo;

import java.awt.*;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2723:48
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " +name ;
    }

    @Override
    public Point multiPoint(Point p, int multi) {
        p.x = p.x * multi;
        p.y = p.y * multi;
        return  p;
    }
}

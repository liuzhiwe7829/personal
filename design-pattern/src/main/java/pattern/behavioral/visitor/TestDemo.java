package pattern.behavioral.visitor;

import java.util.Iterator;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2212:31
 */
public class TestDemo {
    public static void main(String[] args) {
        //创建一个果园
        Orchard orchard = new Orchard();
        //果园中挖坑
        Hole h1 = new AppleHole("1");
        Hole h2 = new AppleHole("2");
        Hole h3 = new AppleHole("3");
        Hole h4 = new OrangeHole("4");
        Hole h5 = new OrangeHole("5");
        orchard.add(h1);
        orchard.add(h2);
        orchard.add(h3);
        orchard.add(h4);
        orchard.add(h5);
        //创建一个树农
        Farmer farmer = new TreeFarmer();
        //开始种树
        Iterator<Hole> iterator = orchard.getIterator();
        while(iterator.hasNext()){
            iterator.next().accept(farmer);
        }
    }
}

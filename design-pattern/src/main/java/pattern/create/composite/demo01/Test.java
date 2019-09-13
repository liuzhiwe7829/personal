package pattern.create.composite.demo01;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1317:40
 */
public class Test {
    public static  void main(String[] args){
        Component component1 = new Composite(1);
        Component component2 = new Composite(2);
        Component component3 = new Composite(3);
        Component leaf = new Leaf(34);
        component1.add(component2);
        component2.add(component3);
        component3.add(leaf);

        System.out.println("从父节点1开始显示");
        component1.show();
        System.out.println("从父节点3开始显示");
        component3.show();

    }
}

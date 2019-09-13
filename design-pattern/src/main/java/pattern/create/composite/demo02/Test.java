package pattern.create.composite.demo02;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1317:40
 */
public class Test {
    public static  void main(String[] args){
        Composite composite1 = new Composite(1);
        Composite composite2 = new Composite(2);
        Composite composite3 = new Composite(3);
        Component leaf = new Leaf(34);
        composite1.add(composite2);
        composite2.add(composite3);
        composite3.add(leaf);

        System.out.println("从父节点1开始显示");
        composite1.show();
        System.out.println("从父节点3开始显示");
        composite3.show();

    }
}

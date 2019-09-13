package pattern.create.composite.demo01;

public class Leaf extends Component {

    public Leaf(int val) {
        this.val = val;
        //构造函数
    }

    @Override
    public void add(Component component) {
        //因为叶子节点不能添加，所有为空
    }

    @Override
    public void remove(Component component) {
        //不能删除，为空
    }

    @Override
    public void show() {
        //输出值
        System.out.println(val);
    }
}
package pattern.create.composite.demo02;

public class Leaf extends Component {

    public Leaf(int val) {
        this.val = val;
        //构造函数
    }

    @Override
    public void show() {
        //输出值
        System.out.println(val);
    }
}
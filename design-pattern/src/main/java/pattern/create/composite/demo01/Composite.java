package pattern.create.composite.demo01;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    List<Component> list = new ArrayList<>();
    //有一个列表来包涵它的子节点

    public Composite(int val) {
        this.val = val;
        //构造函数
    }

    @Override
    public void add(Component component) {
        list.add(component);
        //往列表中加节点

    }

    @Override
    public void remove(Component component) {

        list.remove(component);
        //删列表中的该节点
    }

    @Override
    public void show() {

        System.out.println(val);
        //若是父节点则输出值并遍历出她所有的子节点的值
        for (Component c : list) {
            c.show();
        }

    }
}

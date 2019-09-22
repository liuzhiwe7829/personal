package pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2212:20
 * 数据结构类 ObjectStructure
 * 表示果园类
 */
public class Orchard {
    private List<Hole> holes = new ArrayList<>();

    /**
     * 在果园中挖坑
     *
     * @param hole
     * @return
     */
    public boolean add(Hole hole) {
        return this.holes.add(hole);
    }

    /**
     * 返回遍历坑的迭代器
     *
     * @return
     */
    public Iterator<Hole> getIterator() {
       return  this.holes.iterator();
    }
}

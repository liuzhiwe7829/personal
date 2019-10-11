package pattern.behavioral.memento;

import java.util.ArrayList;

/** 负责人角色
 * @author zhiwei.liu003
 * @date 2019/10/1121:20
 */
public class MementoCaretaker {
    //定义一个集合存储备忘录
    private ArrayList mementoList = new ArrayList();

    public ChessmanMemento getMento(int i) {
        return (ChessmanMemento) mementoList.get(i);
    }

    public void addMento(ChessmanMemento memento){
        mementoList.add(memento);
    }
}

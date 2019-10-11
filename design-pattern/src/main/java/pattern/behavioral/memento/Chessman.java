package pattern.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhiwei.liu003
 * @date 2019/10/1121:13
 */
@Data
@AllArgsConstructor
public class Chessman {
    private String label;
    private int x;
    private int y;

    /**
     * 保存状态
     *
     * @return
     */
    public ChessmanMemento save() {
        return new ChessmanMemento(this.label, this.x, this.y);
    }

    /**
     * 恢复状态
     */
    public void restore(ChessmanMemento memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }

    public void show() {
        System.out.println(String.format("棋子<%s>:当前位置为：<%d,%d>", this.getLabel(), this.getX(), this.getY()));
    }
}

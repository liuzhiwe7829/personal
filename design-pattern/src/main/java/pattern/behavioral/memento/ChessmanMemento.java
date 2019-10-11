package pattern.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhiwei.liu003
 * @date 2019/10/1121:13
 * 备忘录角色
 */
@Data
@AllArgsConstructor
public class ChessmanMemento {
    private String label;
    private int x;
    private int y;
}

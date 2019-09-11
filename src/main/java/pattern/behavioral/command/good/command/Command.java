package pattern.behavioral.command.good.command;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1110:00
 */
public interface Command {
    void  execute();
    void undo();
}

package pattern.behavioral.command.good.command;

import pattern.behavioral.command.good.furniture.TV;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1110:01
 */
public class TVOnCommand implements Command {

    private TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}

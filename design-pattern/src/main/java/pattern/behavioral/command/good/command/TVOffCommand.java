package pattern.behavioral.command.good.command;

import pattern.behavioral.command.good.furniture.TV;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1110:00
 */
public class TVOffCommand  implements  Command{
    private TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}

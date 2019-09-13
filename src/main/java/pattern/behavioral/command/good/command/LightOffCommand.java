package pattern.behavioral.command.good.command;

import pattern.behavioral.command.good.furniture.Light;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1110:00
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

package pattern.behavioral.command.good.command;

import pattern.behavioral.command.good.furniture.Light;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1110:01
 */
public class LightOnCommand implements  Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

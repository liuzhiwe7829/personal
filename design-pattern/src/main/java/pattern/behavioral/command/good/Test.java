package pattern.behavioral.command.good;

import pattern.behavioral.command.good.command.LightOffCommand;
import pattern.behavioral.command.good.command.LightOnCommand;
import pattern.behavioral.command.good.command.TVOffCommand;
import pattern.behavioral.command.good.command.TVOnCommand;
import pattern.behavioral.command.good.furniture.Light;
import pattern.behavioral.command.good.furniture.TV;

/**
 * @author zhiwei.liu003
 * @date 2019/9/119:56
 */
public class Test {
    public  static void main(String[] args){
        Light light = new Light();
        TV tv = new TV();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        TVOffCommand tvOffCommand = new TVOffCommand(tv);
        TVOnCommand tvOnCommand = new TVOnCommand(tv);

        Control control = new Control();
        control.setOnCommand(1,lightOnCommand);
        control.setOffCommand(1,lightOffCommand);
        control.setOnCommand(2,tvOnCommand);
        control.setOffCommand(2,tvOffCommand);
        control.on(1);
        control.on(2);
        control.undo();
        control.off(1);

    }
}

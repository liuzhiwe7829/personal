package pattern.behavioral.command.good;

import pattern.behavioral.command.good.command.Command;
import pattern.behavioral.command.good.command.NoCommand;

import java.util.Stack;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1110:00
 */
public class Control {
    //一列的 开启按钮
    private Command[] onCommands;
    //一列的 关闭按钮
    private Command[] offCommands;
    private  final  int slotNum = 10;

    private Stack<Command> stack = new Stack<>();

    public Control(){
        //初始化 10排
        offCommands = new Command[slotNum];
        onCommands = new Command[slotNum];

        //NoCommand 作用，有可能空余按键
        Command noCommand = new NoCommand();
        for(int i = 0 ; i < onCommands.length ; i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }
    //遥控器不知绑定什么家具  解耦
    //把命令对象设置到遥控器上：把命令封装成类 作为参数命令传进来，绑定到某个插槽
    public void setOnCommand(int slot,Command command){
        onCommands[slot] = command;
    }
    public  void  setOffCommand(int slot,Command command){
        offCommands[slot] = command;
    }
    //三个控制器执行的方法
    public void on(int slot){
        onCommands[slot].execute();
        stack.push(onCommands[slot]);//记录
    }

    public void off(int slot) {
        offCommands[slot].execute();
        stack.push(offCommands[slot]);
    }
    public  void undo(){
        //具体的回退
        //要回退的话，首先要记住按了哪些按钮，可以使用stack
        stack.pop().undo();
    }
}

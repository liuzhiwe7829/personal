package pattern.behavioral.command.bad;

/**
 * @author zhiwei.liu003
 * @date 2019/9/119:56
 */
public class Test {
    public  static void main(String[] args){
        Light light = new Light();
        TV tv = new TV();
        Control control = new Control(light ,tv);
        control.on(1);
        control.on(2);
        control.off(2);
        control.off(2);
    }
}

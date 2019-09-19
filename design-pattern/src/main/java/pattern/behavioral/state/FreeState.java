package pattern.behavioral.state;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1922:46
 * 已入住状态
 */
public class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("房间空闲！");
    }
}

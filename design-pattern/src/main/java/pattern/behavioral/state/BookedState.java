package pattern.behavioral.state;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1922:44
 * 已预定状态
 */
public class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已预订!别人不能预定！");
    }
}

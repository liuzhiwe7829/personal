package pattern.behavioral.state;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1922:48
 * 房间对象
 */
public class HomeContext {
    private  State state;


    public void setState(State s){
        System.out.println("修改状态！");
        state = s;
        state.handle();
    }
}

package pattern.behavioral.state;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1922:50
 */
public class Client {
    public static  void main(String[] args){
        HomeContext ctx = new HomeContext();

        ctx.setState(new FreeState());
        ctx.setState(new BookedState());
    }
}

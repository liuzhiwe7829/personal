package pattern.behavioral.chain;

/**
 * @author zhiwei.liu003
 * @date 2019/9/119:18
 */
public class SpaceFilterChain implements  Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public String handle(String request) {
        if(request.contains(" ")){
            request = request.replace(" ", "");
        }
        // 链式处理完
        if(nextChain != null)
            request = nextChain.handle(request);
        return request;
    }

}

package pattern.behavioral.chain;

/**
 * @author zhiwei.liu003
 * @date 2019/9/119:17
 */
public interface Chain {
    /**
     * 可以写成successor
     * @param nextChain
     */
    void setNextChain(Chain nextChain);

    /**
     * handleRequest
     * @param request
     * @return
     */
    String handle(String request) ;
}

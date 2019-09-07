package designPattern.adapter03;

/**
 * @author zhiwei.liu003
 * @date 2019/9/715:41
 */
public interface IWorkerAdapter {
    //只能放Object,因为传进来的可以实现不同的接口
    String work(Object worker);
    boolean  isSupport(Object worker);
}

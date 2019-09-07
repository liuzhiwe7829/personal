package designPattern.adapter03;

import designPattern.adapter02.ICooker;
import designPattern.adapter02.IProgrammer;

/**
 * @author zhiwei.liu003
 * @date 2019/9/715:43
 */

/**
 * 程序员适配器
 */
public class ProgramerAdapter implements IWorkerAdapter {
    @Override
    public String work(Object worker) {
        return ((IProgrammer)worker).programe();
    }

    @Override
    public boolean isSupport(Object worker) {
        return (worker instanceof  IProgrammer);
    }
}

package pattern.structure.adapter03;

import designPattern.adapter02.ICooker;

/**
 * @author zhiwei.liu003
 * @date 2019/9/715:43
 */

/**
 * 厨师适配器
 */
public class CookerAdapter implements IWorkerAdapter {
    @Override
    public String work(Object worker) {
        return ((ICooker)worker).cook();
    }

    @Override
    public boolean isSupport(Object worker) {
        return (worker instanceof  ICooker);
    }
}

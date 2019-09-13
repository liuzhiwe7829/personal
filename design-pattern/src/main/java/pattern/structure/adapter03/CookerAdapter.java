package pattern.structure.adapter03;


/**
 * @author zhiwei.liu003
 * @date 2019/9/715:43
 */

import pattern.structure.adapter02.ICooker;

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

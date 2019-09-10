package pattern.structure.adapter03;

import designPattern.adapter02.HmJCooker;
import designPattern.adapter02.ICooker;
import designPattern.adapter02.IProgrammer;
import designPattern.adapter02.JDProgrammer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwei.liu003
 * @date 2019/9/715:46
 */
public class MyTest {
    static List<IWorkerAdapter> adapters;
    public static void main (String [] args){
        ICooker iCooker = new HmJCooker();
        IProgrammer iProgrammer = new JDProgrammer();
        Object[] workers = {iCooker,iProgrammer};

        //添所有的适配器
        adapters = new ArrayList<>();
        adapters.add(new CookerAdapter());
        adapters.add(new ProgramerAdapter());

        //工种对象适配器中匹配
        for(Object worker :workers){
            IWorkerAdapter adapter = getAdapter(worker);
            String workContent =adapter.work(worker);
            System.out.println(workContent);
        }
    }

    private static IWorkerAdapter getAdapter(Object worker) {
        for(IWorkerAdapter adapter:adapters){
            if(adapter.isSupport(worker)){
                return  adapter;
            }
        }
        return  null;
    }
}

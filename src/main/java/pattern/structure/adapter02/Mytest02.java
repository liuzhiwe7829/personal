package pattern.structure.adapter02;

/**
 * @author zhiwei.liu003
 * @date 2019/9/715:36
 */
public class Mytest02 {
    public static void main(String[] args){
        ICooker iCooker = new HmJCooker();
        IProgrammer iProgrammer = new JDProgrammer();

        Object[] workers = {iCooker,iProgrammer};
        //创建配置对象
        WorkAdapter adapter = new WorkAdapter();

        //工种对象在适配器中进行匹配
        for(Object worker :workers){
            String workContent = adapter.work(worker);
            System.out.println(workContent);
        }
    }
}

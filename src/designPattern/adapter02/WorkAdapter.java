package designPattern.adapter02;

/**
 * @author zhiwei.liu003
 * @date 2019/9/712:25
 */
public class WorkAdapter {
    public String work(Object worker) {
        String workContent = "";

        //
        if (worker instanceof ICooker) {
            workContent = ((ICooker) worker).cook();
        }
        if (worker instanceof JDProgrammer) {
            workContent = ((IProgrammer) worker).programe();
        }
        return workContent;
    }
}

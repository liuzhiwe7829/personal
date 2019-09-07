package designPattern.adapter02;

/**
 * @author zhiwei.liu003
 * @date 2019/9/712:22
 */
public class Mytest01 {
    public static void main(String[] args) {
        ICooker iCooker = new HmJCooker();
        IProgrammer iProgrammer = new JDProgrammer();

        //各自职责 无法循环遍历
        System.out.println(iCooker.cook());
        System.out.println(iProgrammer.programe());
    }
}

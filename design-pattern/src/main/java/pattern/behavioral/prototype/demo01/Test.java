package pattern.behavioral.prototype.demo01;

import pattern.behavioral.prototype.demo01.Resume;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1314:36
 */
public class Test {
    public static void main(String[] args) {
        Resume resume1 = new Resume();
        resume1.setName("小赵");
        resume1.setPosition("高级铸剑工程师");
        resume1.setSalary(1000);

        Resume resume2 = new Resume();
        resume2.setName("小赵");
        resume2.setPosition("高级铸剑工程师");
        resume2.setSalary(1200);

        Resume resume3 = new Resume();
        resume2.setName("小赵");
        resume3.setPosition("高级铸剑工程师");
        resume3.setSalary(1500);
        //.....

//        int num = 5;
//        while (num > 0){
//            Resume resume1 = new Resume();
//            int salary = (int)(1000+Math.random()*(2000-1000+1));
//            resume1.setName("小赵");
//            resume1.setPosition("高级铸剑工程师");
//            resume1.setSalary(salary);
//            System.out.println(resume1.toString());
//            num --;
//        }
    }
}

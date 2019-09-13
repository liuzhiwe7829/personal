package pattern.behavioral.prototype.demo02;

import pattern.behavioral.prototype.demo01.Resume;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1314:36
 *
 * 浅拷贝
 */

/**
 * 1.在需要一个类的大量对象的时候，使用原型模式是最佳选择，因为原型模式是在内存中对这个对象进行拷贝，要比直接new这个对象性能要好很多，在这种情况下，需要的对象越多，原型模式体现出的优点越明显。
 *
 * 　　2.如果一个对象的初始化需要很多其他对象的数据准备或其他资源的繁琐计算，那么可以使用原型模式。
 *
 * 　　3.当需要一个对象的大量公共信息，少量字段进行个性化设置的时候，也可以使用原型模式拷贝出现有对象的副本进行加工处理。
 */
public class Test {
    public static void main(String[] args) {
        int num = 5;
        while (num > 0){
            Resume resume1 = new Resume();
            int salary = (int)(1000+Math.random()*(2000-1000+1));
            resume1.setName("小赵");
            resume1.setPosition("高级铸剑工程师");
            resume1.setSalary(salary);
            System.out.println(resume1.toString());
            num --;
        }
    }
}

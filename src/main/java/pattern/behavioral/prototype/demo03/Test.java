package pattern.behavioral.prototype.demo03;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1315:17
 */
public class Test {
    public static void main(String[] args) {
        int salary = (int) (1000 + Math.random() * (2000 - 1000 + 1));
        Resume resume1 = new Resume1("小赵", "高级铸剑工程师", salary);
        System.out.println(resume1);
        Resume resume2 = resume1.clone();
        System.out.println(resume2);
    }
}


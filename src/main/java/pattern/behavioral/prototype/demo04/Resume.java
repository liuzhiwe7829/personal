package pattern.behavioral.prototype.demo04;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1315:05
 */

/**
 * 抽象原型角色
 */

public abstract class Resume {
    private String name;
    private String position;
    private int salary;

    public Resume(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    /**
     * 克隆自身的方法
     *
     * @return 一个从自身克隆出来的对象。
     */

    public abstract Resume clone();

}

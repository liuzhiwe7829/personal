package pattern.behavioral.prototype.demo02;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1314:32
 */
public class Resume  implements  Cloneable{
    private String name;
    private String position;
    private int salary;

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
    protected  Resume clone(){
        Resume resume = null;
        try{
            resume = (Resume)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  resume;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}


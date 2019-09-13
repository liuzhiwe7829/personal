package pattern.behavioral.prototype.demo04;
public class Resume1 extends Resume {

    public Resume1(String name,String position,int salary) {
        super(name,position,salary);
    }

    @Override
    public Resume clone() {
        Resume resume = new Resume1(this.getName(), this.getPosition(), this.getSalary());

        System.out.println("--------------");
        return resume;
    }
}
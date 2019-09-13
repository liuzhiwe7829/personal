package pattern.behavioral.prototype.demo04;

public class Resume2 extends Resume {

    public Resume2(String name, String position, int salary) {
        super(name, position, salary);
    }

    @Override
    public Resume clone() {
        Resume resume = new Resume2(this.getName(), this.getPosition(), this.getSalary());
        return resume;
    }
}
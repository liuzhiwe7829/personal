# 原型模式
[toc]
## 1. 场景
代码结构

![image](A194D275AA484C5382B03D8B1A8C8E01)

bean



```
public class Resume {

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
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
```




测试类
```
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
```

### 1.1 浅拷贝
### 1.2 深拷贝
## 2. 表现形式
### 2.1 简单形式
类图
![image](5C2227C5653A4DEDA621806F1A15BC20)
运行截图

![image](0C73FC2827474E4E945F79258A5B6CC4)

### 2.3 登记形式
类图

![image](284A3FFAF448439490F9A0DB69171082)

运行截图

![image](9535848B7DF64D31A9BF2F0A6C7C2FDF)

参考文章:



1. [《原型模式》](https://www.cnblogs.com/fengyumeng/p/10646487.html)
2. [一天一个设计模式:原型模式（Prototype）](https://www.toutiao.com/a6682901223282049540/)
package pattern.behavioral.prototype.demo04;

public class Client {

    public static void main(String[] args) {
        try {
            // 创建第一个实例
            int salary = (int) (1000 + Math.random() * (2000 - 1000 + 1));
            Resume p1 = new Resume1("小赵", "高级铸剑工程师", salary);
            // 注册第一个实例
            ResumeManager.setProtoType("p1", p1);
            // 克隆第一个实例的原型
            Resume p3 = ResumeManager.getPrototype("p1").clone();
            p3.setName("张三");
            System.out.println("第一个实例的副本：" + p3);
            // 创建第二个实例
            Resume p2 = new Resume2("小赵", "中级铸剑工程师", salary);
            // 注册第二个实例
            ResumeManager.setProtoType("p2", p2);
            // 克隆第二个实例的原型
            Resume p4 = ResumeManager.getPrototype("p2").clone();
            System.out.println("第二个实例的副本：" + p4);
            // 注销第一个实例
            ResumeManager.removePrototype("p1");
            // 再次克隆第一个实例的原型
            Resume p5 = ResumeManager.getPrototype("p1").clone();
            p5.setName("王五");
            System.out.println("第一个实例的副本：" + p5);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
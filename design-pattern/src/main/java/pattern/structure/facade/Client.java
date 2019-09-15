package pattern.structure.facade;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1510:54
 */
public class Client {
    public static void main(String[] args){
        Facade facade = new Facade();

    }

    // 外观角色 Facade
    static class Facade {
        private SubSystemA a = new SubSystemA();
        private SubSystemB b = new SubSystemB();
        private SubSystemC c = new SubSystemC();

        // 对外接口
        public void doA() {
            this.a.doA();
        }

        // 对外接口
        public void doB() {
            this.b.doB();
        }

        // 对外接口
        public void doC() {
            this.c.doC();
        }
    }

    // 子系统
    static class SubSystemA {
        public void doA() {
            System.out.println("doing A stuff");
        }
    }

    // 子系统
    static class SubSystemB {
        public void doB() {
            System.out.println("doing B stuff");
        }
    }

    // 子系统
    static class SubSystemC {
        public void doC() {
            System.out.println("doing C stuff");
        }
    }
}

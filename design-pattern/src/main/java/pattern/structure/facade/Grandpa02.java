package pattern.structure.facade;

class Grandpa02 {
    public static void main(String[] args) {
        ControllerFacade facade = new ControllerFacade();
        System.out.println("起床了");
        facade.on();

        System.out.println("准备睡觉了");
        facade.off();
        System.out.println("电器已全部关闭，可以安心睡觉了");

    }

    static class ControllerFacade {
        private Light light = new Light();
        private Television tv = new Television();
        private Aircondition ad = new Aircondition();

        public void on() {
            this.light.on();
            this.tv.on();
            this.ad.on();
        }

        public void off() {
            this.light.off();
            this.tv.off();
            this.ad.off();
        }

    }

    static class Light {
        public void on() {
            System.out.println("开灯");
        }

        public void off() {
            System.out.println("关灯");
        }
    }

    static class Television {
        public void on() {
            System.out.println("打开电视");
        }

        public void off() {
            System.out.println("关电视");
        }
    }

    static class Aircondition {
        public void on() {
            System.out.println("打开空调");
        }

        public void off() {
            System.out.println("关空调");
        }
    }
}
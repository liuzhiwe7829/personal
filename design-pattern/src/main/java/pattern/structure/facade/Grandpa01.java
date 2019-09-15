package pattern.structure.facade;

class Grandpa01 {
    public static void main(String[] args){
        Light light = new Light();
        Television tv = new Television();
        Aircondition ad = new Aircondition();

        System.out.println("起床了");
        light.on();
        tv.on();
        ad.on();

        System.out.println("准备睡觉了");
        light.off();
        tv.off();
        ad.off();
        System.out.println("电器已全部关闭，可以安心睡觉了");

    }

    static class Light{
        public void on(){
            System.out.println("开灯");
        }

        public void off(){
            System.out.println("关灯"); 
        }
    }

    static class Television {
        public void on(){
            System.out.println("打开电视");
        }

        public void off(){
            System.out.println("关电视"); 
        } 
    }

    static class Aircondition {
        public void on(){
            System.out.println("打开空调");
        }

        public void off(){
            System.out.println("关空调"); 
        } 
    }
}
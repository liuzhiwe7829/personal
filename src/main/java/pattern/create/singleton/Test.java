package pattern.create.singleton;

public class Test {

    public static void main(String[] args){
        // 单例测试
        Singleton s1 = Singleton.INSTANCE;
        s1.setName("firstName");
        System.out.println("s1.getName(): " + s1.getName());

        Singleton s2 = Singleton.INSTANCE;
        s2.setName("secondName");

        //注意我这里输出s1 ，但是已经变成了 secondName
        System.out.println("s1.getName(): " + s1.getName());
        System.out.println("s2.getName(): " + s2.getName());

        System.out.println("-----------------");

        // 反射获取实例测试
        Singleton[] enumConstants = Singleton.class.getEnumConstants();
        for (Singleton enumConstant : enumConstants)
            System.out.println(enumConstant.getName());
    }
}
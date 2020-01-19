import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhiwei.liu003
 * @date 2020/1/199:51
 * https://mp.weixin.qq.com/s?__biz=MzIwMDY0Nzk2Mw==&mid=2650320988&idx=2&sn=435a8cf53ae534cdb2a70f16382a690d&chksm=8ef5e428b9826d3e263ed33ddb7d03ee9142bc7d3c8ca2d4d54bb7c47046ac77ba8cf70c88cc&scene=126&sessionid=1579167248&key=5da8b0f3df3c0505f021e514bdab92e623223663911a1038be6112feca2588df03b9119ef4e61a063d302ecc0a72ddb9008f11cb7684108b781f7486a0fdc5ae926f0187267d3eef223801d8622fd345&ascene=1&uin=NzAwNjMyNjgx&devicetype=Windows+10&version=6208006f&lang=zh_CN&exportkey=AadaSbIddsEkmGb9ZDZ8vUA%3D&pass_ticket=eoPeT7QWAgqbmd38GarJjXoh4oWSmxuX6f3g7M7%2Fn42uz6R7jtO%2FvAo2J66wMoEL
 */
public class JDK8Demo {
    public static void main(String agrs[]) throws IOException {
        /**
         *  判空操作
         */
        Object obj = null;
        //优化之前
        if (obj != null) {
        }
        //优化之后
        if (Optional.ofNullable(obj).isPresent()) {

        }

        /**
         * 判空异常操作
         */
        //优化之前
        if (obj == null) {
//            throw new ...
        }
        //优化之后
        Optional.ofNullable(obj).orElseThrow(() -> new RuntimeException(""));

        /**
         * 返回空值
         */
//        List list = null;
//        //优化之前
//        if (list == null) {
//            return new ArrayList<>();
//        }
//        return list;
//        //优化之后
//        return Optional.ofNullable(list).orElse(new ArrayList<>());
        /**
         * 求最大值最小值
         */
        Integer max = Stream.of(1, 2, 3, 4).max(Integer::compareTo).get();
        Integer min = Stream.of(1, 2, 3, 4).min(Integer::compareTo).get();
        /**
         * 去重操作
         */
        //优化之前
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        Set<Integer> set = new HashSet(list);
        //优化之后
        List<Integer> temp = list.stream().distinct().collect(Collectors.toList());

        /**
         * 集合判空遍历操作
         */
        //优化之前
        if (list == null) {
            return;
        }
        for (Integer s : list) {

        }
        //优化之后
        Optional.ofNullable(list).orElse(new ArrayList<>()).stream().forEach(s -> {

        });

        /**
         * 匿名内部类
         */
        // 优化之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("java8");
            }
        }).start();
        //优化之后
        new Thread(() -> System.out.println("java8!"));

        /**
         * 预约计算
         */
        //基于数据流的方式，将流装在成相应的 SummaryStatics 进行规约计算，实现更多的操作;
        IntSummaryStatistics statistics = list.stream().mapToInt(i -> i).summaryStatistics();
        int max1 = statistics.getMax();// 获取最大值
        int min1 = statistics.getMin();//获取最小值
        double sum = statistics.getSum();//获取总值
        double avg = statistics.getAverage();//获取平均值
        long count = statistics.getCount();// 获取总数量

        /**
         * 排序
         */
        List<Integer> temp1 = Stream.of(2, 1, 3, 5, 0, 6).sorted().collect(Collectors.toList());
        //自己定制排序方式
        List<Integer> temp2 = Stream.of(2, 1, 3, 5, 0, 6).sorted((x, y) -> Integer.compare(x, y)).collect(Collectors.toList());

        /**
         * 求和
         */
        //优化前
        List<Integer> list1 = new ArrayList<>();
        Integer sum1 = 0;
        for (Integer i : list) {
            sum1 = sum1 + i;
        }
        //优化之后
        //方式一
        sum1 = list1.stream().mapToInt(Integer::intValue).sum();
        sum1 = list1.stream().mapToInt(Integer::intValue).sum();
        //方式二
//        sum1 = list1.stream().reduce((x,y)->x+y);
        /**
         * 过滤
         */
        //优化之前
        List<Integer> list2 = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            if (i % 2 == 0) {
                newList.add(i);
            }
        }
        //优化之后
        newList = list.stream().filter(i -> i % 2 == 2).collect(Collectors.toList());

        /**
         * 分组归类
         */
        List<Student> studentList = Arrays.asList(new Student(1, "one", "zhao"),
                new Student(2, "one", "qian"),
                new Student(3, "two", "sun"));
        //根据某个属性分组统计
        Map<String, Long> map = new HashMap<>();
        for (Student s : studentList) {
            if (map.containsKey(s.getGroupId())) {
                Long l = map.get(s.getGroupId());
                map.put(s.getGroupId(), l + 1);
            } else {
                map.put(s.getGroupId(), 1L);
            }
        }
        //优化之后
        map = studentList.stream().collect(Collectors.groupingBy(Student::getGroupId, Collectors.counting()));

//        functionTest(n ->{
//            return String.valueOf(n);
//        },studentList.new java.util.ArrayList<>())
        /**
         * 并行流计算
         */
        List<String> list4 = new ArrayList();
        for (String no : list4) {
            //下发
        }
        //优化之后，parallel 是多个线程并发的，这个底层是fork-join,线程数和cpu核数相等
        //这种写法应该放置因parallel的线程数耗尽，导致后面的请求的排队，从而超时 ，甚至雪崩，压垮服务
        list.stream().parallel().forEach(no -> {
        });

        /**
         * List转换Map,key 冲突处理
         */
        List<String> list5 = new ArrayList<>();
        list5.stream().collect(Collectors.toMap(
                //map的key
                s -> {
                    return s;
                },
                //map的value
                s -> {
                    return 1;
                },
                //当key冲突时，value相加
                (Integer src, Integer des) -> {
                    return src + des;
                }
        ));
        /**
         * 读取文件
         */
        final Path path = new File("D:\\1.txt").toPath();
        //必须放入try  with resource 语法，这个流是需要关闭的，或者try catch finally手动关闭流
        try (Stream<String> lines = Files.lines(path)) {
            lines.onClose(() -> {
                System.out.println("down");
            }).forEach(System.out::println);
        } catch (Exception e) {

        }
        //如果出现下面得异常，看看文件编码，指定成utf-8
        //当输入字节序列对于给定 charset 来说是不合法的，或者输入字符序列不是和发的16位Unicode
//        java.nio.charset.MalformedInputException: Input length =1;


        /**
         * 截取流的前N个元素
         */
        List<String> list6 = Arrays.asList("hello", "I", "love", "you");
        List<String> temp3 = list6.stream().limit(3).collect(Collectors.toList());

        /**
         * 跳过流的前N个元素
         */
        List<String> temp4 = list6.stream().skip(2).collect(Collectors.toList());
        /**
         * 跳过流的前N个元素
         */
        List<String> list7 = Arrays.asList("hello", "I", "love", "you");
        //返回配到的元素
        Optional<String> str2 = list7.stream().filter(s -> {
            return ("hello").equals(s);
        }).findFirst();
        /**
         * 匹配任何一个则返回
         */
        boolean flag = list6.stream().anyMatch(s->s.equals("hello"));
    }

    /**
     * 定义函数式方法
     */
    //functionTest 入参接受一个函数，这个函数入参是Integer,出参是String
    public void functionTest(Function<Integer, String> apply, List<Integer> nums) {
        nums.forEach(n -> {
            String result = apply.apply(n);
            System.out.println(result);
        });
    }
}

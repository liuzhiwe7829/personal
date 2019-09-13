package pattern.behavioral.chain;

/**
 * @author zhiwei.liu003
 * @date 2019/9/119:18
 */
public class Test {

    public static void main(String[] args) {

        Chain c1 = new HTMLFilterChain();      // 过滤字符串的html
        Chain c2 = new SensitiveFilterChain(); // 过来字符串的敏感信息
        Chain c3 = new SpaceFilterChain();     //过滤字符串的空格

        c1.setNextChain(c2); // 也可以通过构造函数设置某个的nextChain
        c2.setNextChain(c3);

        String notGoodStr = "<html>爱祖国，爱人民，我很敏感<body>"; // 里面有html和敏感信息要去除(没有空格)

        notGoodStr = c1.handle(notGoodStr);

        System.out.println(notGoodStr); // good Str
    }

}

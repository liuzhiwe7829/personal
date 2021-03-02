package HJ106;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/221:01
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 */
public class Main {
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        String param = in.nextLine();
        char [] chars = param.toCharArray();
        int len = chars.length-1;
        while(len>=0){
            System.out.print(chars[len]);
            len--;
        }
        System.out.println();

    }
}

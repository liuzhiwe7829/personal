package HJ10;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/611:49
 *
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * 输入描述:
 * 输入一行没有空格的字符串。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            char [] chars = str.toCharArray();
            HashSet set = new HashSet<Character>();
            for(int i = 0 ;i <chars.length;i++){
                if(chars[i]>0&& chars[i]<127){
                    set.add(chars[i]);
                }
            }
            System.out.println(set.size());
        }
    }
}

package HJ96;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/323:12
 * <p>
 * 将一个字符中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 * <p>
 * 注意：本题有多组样例输入。
 * 输入描述:
 * 输入一个字符串
 * <p>
 * 输出描述:
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 * <p>
 * 示例1
 * 输入
 * 复制
 * Jkdi234klowe90a3
 * 5151
 * 输出
 * 复制
 * Jkdi*234*klowe*90*a*3*
 * *5151*
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            char[] chars = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            //*号数量统计
            int count = 0;
            //前后类型是否一致
            boolean flag;
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                //首位
                if (Character.isDigit(temp)&&i==0) {
                    sb.append("*");
                    sb.append(temp);
                    count++;
                }else
                    //最后一位数字
                    if ((i == chars.length - 1) && Character.isDigit(chars[chars.length - 1])) {
                        sb.append(temp);
                        sb.append("*");
                 } else
                //中间  数字-字母
                if (Character.isDigit(temp) &&Character.isLetter(chars[i+1])) {
                    sb.append(temp);
                    sb.append("*");
                    count++;
                }else if (Character.isLetter(temp) &&Character.isDigit(chars[i+1])) {
                    sb.append(temp);
                    sb.append("*");
                    count++;
                }else {
                    sb.append(temp);
                }
            }
            System.out.println(sb.toString());
        }
    }
}

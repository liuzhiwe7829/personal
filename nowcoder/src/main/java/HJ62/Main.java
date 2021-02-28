package HJ62;

import java.util.Scanner;

/**
 *
 * 题目描述
 *
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 * 输入描述:
 * 输入一个整数
 *
 * 输出描述:
 * 计算整数二进制中1的个数
 *
 * 示例1
 * 输入
 * 复制
 * 5
 * 输出
 * 复制
 * 2
 * 说明
 * 5的二进制表示是101，有2个1
 *
 * @author zhiwei.liu003
 * @date 2021/2/2822:39
 */
public class Main {
    public  static  void main (String args[]){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int param = in.nextInt();
            System.out.println(calc(param));
        }
    }

    private static int calc(int n) {
        int count =0;
        while(n!=0) {
            if ((n & 1) == 1) {
                count++;
            }
            //无符号右移 补0
            n=n>>>1;
        }
        return count;
    }
}

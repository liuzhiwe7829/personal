package HJ108;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/220:36
 *
 *
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述:
 * 输入两个正整数A和B。
 *
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 * 示例1
 * 输入
 * 复制
 * 5 7
 * 输出
 * 复制
 * 35
 */
public class Main {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(a*b/gcd(a,b));
    }

    private static int gcd(int a, int b) {
        if(a<b){
            int temp = b;
            b = a ;
            a=temp;
        }
        if(a%b==0) {
            return b;
        } else {
            return gcd(b,a%b);
        }
    }
}

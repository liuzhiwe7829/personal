package HJ76;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/30:24
 *
 * 题目描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * m*m*m = n
 * Sn= na1+n(n-1)d/2
 * m*m*m = m*a1 +m*(m-1)2/2
 * m*m*m = m*a1 +m*m-m
 * m*m = a1+m-1
 * a1 = m*m-m+1
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 本题含有多组输入数据。
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 输出分解后的string
 *
 * 示例1
 * 输入
 * 复制
 * 6
 * 输出
 * 复制
 * 31+33+35+37+39+41
 */
public class Main {
public static  void main (String [] args){
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
        int m = in.nextInt();
        int a1= m*m-m+1;
        StringBuffer sb= new StringBuffer();
        sb.append(a1);
        for(int i = 1 ;i<m;i++){
            a1+=2;
            sb.append("+"+a1);
        }
        System.out.println(sb.toString());
    }
}

}

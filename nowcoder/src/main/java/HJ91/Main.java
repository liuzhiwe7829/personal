package HJ91;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/221:35
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 *
 * 本题含有多组样例输入。
 * 输入描述:
 * 每组样例输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 *
 * 输出描述:
 * 每组样例输出一行结果
 *
 * 示例1
 * 输入
 * 复制
 * 2 2
 * 1 2
 * 输出
 * 复制
 * 6
 * 3
 *
 * f(n,m) = f(n-1,m)+f(n,m-1);
 * n ==0  m==0
 */
public class Main {
    public static  void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(count(n,m));
        }
    }

    private static int count(int n, int m) {
        if(n==0|| m ==0) {
            return  1;
        }else{
            return count(n-1,m)+count(n,m-1);
        }
    }
}

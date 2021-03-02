package HJ100;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/221:10
 *
 * 功能:等差数列 2，5，8，11，14。。。。
 * num(n) = 2+(n-1)*d = 2+（n-1）*3 = 3n-1
 * sum(n)= (2+3n-1)*n/2 = (3n+1)*n/2 =3/2n^2+(1/2)*n
 * 输入:正整数N >0
 *
 * 输出:求等差数列前N项和
 */
public class Main {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            int n = in.nextInt();
            System.out.println(sum(n));
        }
    }
    private static int sum(int n) {
        return (3*n+1) *n/2;
    }
}

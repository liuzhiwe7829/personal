package HJ35;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/614:24
 *
 * 第0行， j=0+1，每一位数字为：(j*j+j)/2
 * 第1行， j=1+1，每一位数字为：(j*j+j)/2-1.即为，去掉上一行的第一个数，然后后面的数补上来，并且减1
 *  2     j=2+1 (j*j+j)/2-2
 *  i  j=i+1  num = (j*j+j)/2-i
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 例如，当输入5时，应该输出的三角形为：
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            for(int i= 0;i <n;i++){
                for(int j =(i+1);j<=n;j++){
                    System.out.print((j*j+j)/2-i +" ");
                }
                System.out.println();
            }
        }
    }
}

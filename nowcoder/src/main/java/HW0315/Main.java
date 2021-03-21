package HW0315;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/1519:43
 * 0!=1,n!=(n-1)!*n
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        int n = 3;
        System.out.println(cal(n));

    }

    private static int cal(int n) {
        if(n == 0) {
            return  1;
        }else {
            return cal(n-1)*n;
        }

    }
}

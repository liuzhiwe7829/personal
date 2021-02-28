package HJ61;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/2/2822:15
 */
public class Main {
    /**
     * f(m,n) m苹果 n盘子
     * 盘子大于苹果
     *  n>m n-m空盘  if(n>m)=f(m,m)
     *  n<=m
     *      至少一个盘子空着 f(m,n)=f(m,n-1)+f(m-n,n)
     *  n=1 返回1
     *  m=0 当没有苹果时 返回
     */
    public static  void main (String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            int res= -1;
            if(n>=1 && n<=10 && m>=1 && m<=10){
                res = count(m,n);
            }
            System.out.println(res);
        }
    }

    private static int count(int m, int n) {
        // 苹果没了  盘子只有一个
        if(m==0 || n==1) {
            return 1;
        }
        //盘子大于苹果
        if(n>m) {
            return  count(m,m);
        }
        return  count(m,n-1)+count(m-n,n);

    }
}

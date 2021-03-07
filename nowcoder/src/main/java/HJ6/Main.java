package HJ6;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/610:33
 *
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 */
public class Main {
    public  static  void  main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            long n = in.nextLong();
            for(int i =2 ; i<=n;){
                if(n%i==0){
                    System.out.print(i+" ");
                    n/=i;
                    //重置除数
                    i=2;
                } else if(n%i!=0){
                    i++;
                }
            }
            System.out.println(n==1?" ":n+" ");
        }
    }
}

package HJ103;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/321:33
 */
public class Main {
    public static  void main(String [] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            int [] orgin = new int[num];
            int [] dp = new int[num];
            int res = 0;
            Arrays.fill(dp,1);
            for(int i = 0 ;i <num;i++){
                orgin[i] = in.nextInt();
            }
            for(int i=1;i< dp.length;i++){
                for(int j= 0 ;j<i;j++){
                    if(orgin[j]<orgin[i]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                res =Math.max(res,dp[i]);
            }
            System.out.println(res);
        }
    }
}

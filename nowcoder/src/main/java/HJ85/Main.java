package HJ85;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/223:27
 */
public class Main {
//    public static void main(String [] args){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            String param = in.nextLine();
//            StringBuffer sb=new StringBuffer();
//            sb.append(param);
//            sb.reverse();
//            int max=0;
//            for(int i = 0 ;i<param.length();i++){
//                for(int j = i+1 ;j<param.length();j++){
//                    if(param.contains(sb.substring(i,j))){
//                        if(j-i>max){
//                            max = j-i;
//                        }
//                    }
//                }
//            }
//            System.out.println(max);
//        }
//    }

    public  static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            System.out.println(getStr(str));


        }
    }

    private static int getStr(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        boolean [][] dp = new boolean[len][len];
        if(len <2 ) return len;
        int start =0;
        int end =0;
        int max = 0;
        /*  初始化
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }*/
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(chars[i]==chars[j]){
                    if(j-i<3) dp[i][j]=true;
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                    if(dp[i][j]){
                        if(j-i+1>max){
                            max=j-i+1;
                            start=i;
                            end=j;
                        }
                    }
                }
            }//for j end
        }//for i end
        //display
//        display(dp);
    return  max;
    }

    private static void display(boolean[][] dp) {
        for(int i = 0 ;i<dp.length;i++){
            for(int j =0 ;j<dp.length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

    }
}

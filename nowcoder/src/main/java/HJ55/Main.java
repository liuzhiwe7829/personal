package HJ55;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/710:49
 */
public class Main {
    public static  void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int count =0;
            for(int i=7 ;i<=n;i++){
                if(contain7(i)||i%7==0){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean contain7(int n) {
        while(n!=0){
            if(n%10==7){
              return true;
            }
            n/=10;
        }
        return false;
    }
}

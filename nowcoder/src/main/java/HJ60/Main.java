package HJ60;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/716:09
 */
public class Main {
    public  static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int start = n/2;
            for(int i = start ;i <n;i++ ){
                if(isP(i)&& isP(n-i)){
                    System.out.println(n-i);
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static boolean isP(int start) {

        for(int i =2; i<=Math.sqrt(start);i++){
            if(start%i==0){
                return false;
            }
        }
        return true;
    }
}

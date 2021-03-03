package HJ99;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/323:01
 * 自守数 0，1,5,6
 */
public class Main {
    public  static void main (String[] args ){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            int count = 0;
            for(int i = 0; i<=num ;i++){
                if(i%10 ==0|| i%10==1|| i%10==5 ||i%10==6){
                    int cal = i*i;
                    if(String.valueOf(cal).endsWith(String.valueOf(i))){
                        count++;
                    }

                }
            }
            System.out.println(count);
        }
    }
}

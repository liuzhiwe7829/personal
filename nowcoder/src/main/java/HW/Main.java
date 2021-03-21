package HW;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhiwei.liu003
 * @date 2021/3/1416:15
 */
public class Main {
    public static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num[] = new int[n];
        for(int i = 0;i <n ;i++){
            num[i] = in.nextInt();
        }
        boolean flag = true;
        for(int i =0 ;i<num.length;i++){
            if(!flag) {
                break;
            }
            int a = num[i];
            for(int j =0 ;j<num.length;j++){
                int b= num[j];
                if(!flag) {
                    break;
                }
                    for(int k = 0 ;k<num.length;k++) {
                        int c = num[k];
                        if((a==(b+c*2))&&k!=i&& k!=j&& i!=j) {
                            System.out.println(a + " " + b + " " + c);
                            flag = false;
                            break;
                        }
                }
            }
        }
        if(flag){
            System.out.println(0);
        }

    }
}

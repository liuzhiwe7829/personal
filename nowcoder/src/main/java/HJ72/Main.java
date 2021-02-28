package HJ72;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/10:13
 */
public class Main {
    public static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        int money = in.nextInt()*100;
        int maxA= money/5;
        int maxB= money/3;
        for(int i = 0 ;i< maxA ;i++){
            for(int j= 0 ;j <maxB;j++){
               int  k= money -i -j;
                if((i*5+j*3+k/3)==money&& k%3==0){
                        System.out.println(i + " " + j +  " " + k);
                    }
                }
            }
        }
    }

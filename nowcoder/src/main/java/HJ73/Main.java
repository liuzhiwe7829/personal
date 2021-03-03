package HJ73;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/320:09
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String param = in.nextLine();
            String [] dateArray = param.split(" ");
            int [] year1 ={31,28,31,30,31,30,31,31,30,31,30,31};
            int [] year2 ={31,29,31,30,31,30,31,31,30,31,30,31};
            int year = Integer.valueOf(dateArray[0]);
            int month = Integer.valueOf(dateArray[1]);
            int day = Integer.valueOf(dateArray[2]);
            int count = 0;
            if((year %100== 0)&& (year%400 ==0) || (year %100!= 0)&& (year%4 ==0)){
                for(int i = 0 ; i< month-1;i++){
                    count+=year2[i];
                }
            }else{
                for(int i = 0 ; i< month-1;i++){
                    count+=year1[i];
                }
            }
            System.out.println(count+day);
        }
    }
}

package HJ107;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/320:29
 */
public class Main {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            double param = in.nextDouble();
            double start = 0.0;
            double end = param;
            double mid = 0.0;
            boolean flag ;
            if(param>0) {
                flag = true;
            }else {
                flag = false;
                param = -1*param;
            }
            while(start<end ){
                mid = (start+end)/2.0;
                double val = mid * mid * mid;
                double m= Math.abs(param-val);
                    if(m<0.00001) {
                        break;
                    }else if( val>param){
                        end = mid;
                    }else if(val<param){
                        start=mid;
                    }
            }
            double res = mid;
            if(!flag){
                res =- mid;
            }

            System.out.printf("%.1f\n",res);
        }
    }
}

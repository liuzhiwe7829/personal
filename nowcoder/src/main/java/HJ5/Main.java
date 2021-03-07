package HJ5;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/323:59
 * 进制转换 16->10
 */
public class Main {
    public  static  void main(String [] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            //去除16进制标识 0x
            str=str.substring(2);
            //库函数
//            System.out.println(Integer.parseInt(str.replace("x",""),16));
            char[] chars= str.toCharArray();
            int total=0;
            int len = chars.length;
            for(int i= 0; i<chars.length;i++){
                //计算所处数位需扩大指数个数
                int index = len-i-1;
                int temp = 0;
                //被乘数
                int mult=1;
                if(chars[i]>='A'){
                    temp = chars[i]-'A'+10;
                }else if(chars[i]>='a'){
                    temp = chars[i]-'a'+10;
                }else {
                    temp = chars[i]-'0';
                }
                for(int j =0;j<index;j++){
                    mult*=16;
                }
                total=total+temp*mult;
            }
            System.out.println(total);
        }

    }
}

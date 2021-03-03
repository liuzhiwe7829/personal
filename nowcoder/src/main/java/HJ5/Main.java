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
            str=str.substring(2);
//            System.out.println(Integer.parseInt(str.replace("x",""),16));
            char[] chars= str.toCharArray();
            int total=0;
            int count =1;
            int len = chars.length-1;
            while(len>=0){
                char temp = chars[len];
                int b = 1;
                int ten=0;
                for(int i = 1;i<count;i++){
                    b*=16;
                }
                if(temp>'A'){
                    ten=(temp -'A'+10)*b;
                }else{
                    ten=(temp-'a'+10);
                }
                total+=ten;
            }
            System.out.println(total);
        }
    }
}

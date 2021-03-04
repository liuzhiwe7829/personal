package HJ90;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/323:15
 *
 * ip合法校验
 * 输入描述:
 * 输入一个ip地址，保证是xx.xx.xx.xx的形式（xx为整数）
 *
 * 输出描述:
 * 返回判断的结果YES or NO
 */
public class Main {
    public static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String [] array = str.split("\\.");
            boolean flag = true;
            //长度
            if(array.length!=4) {
                flag =false;
            }
            // 0-255
            for(String string:array){
                int temp =Integer.valueOf(string);
                if(temp<0|| temp>255 ) {
                    flag=false;
                    break;
                }
            }
            System.out.println(flag?"YES":"NO");
        }
    }
}

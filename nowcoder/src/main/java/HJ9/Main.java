package HJ9;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/611:42
 *
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 */
public class Main {
    public  static  void  main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            char [] chars = str.toCharArray();
            String res ="";
            for(int i = chars.length-1;i>=0;i--){
                if(!res.contains(chars[i]+"")){
                    res+=chars[i]+"";
                }
            }
            System.out.println(Integer.valueOf(res));
        }
    }
}

package HJ84;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/30:14
 * 统计大写字母
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            char[] chars = str.toCharArray();
            int count = 0;
            for(int i= 0;i<chars.length;i++){
                if(Character.isUpperCase(chars[i])){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

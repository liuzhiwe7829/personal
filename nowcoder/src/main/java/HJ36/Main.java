package HJ36;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/616:42
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            LinkedHashSet<Character> keySet = new LinkedHashSet<>();
            String keyStr = in.nextLine();
            String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for(int i = 0 ;i <keyStr.length();i++){
                //转化大写
                keySet.add(Character.toUpperCase(keyStr.charAt(i)));
            }
            //
            for(int i =0 ;i< 26;i++){
                keySet.add(str.charAt(i));
            }
            String tarStr = in.nextLine();
            List<Character> list = new ArrayList<>(keySet);
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ;i <tarStr.length();i++){
                char temp = tarStr.charAt(i);
                if(temp>='A' &&temp <='Z'){
                    int n = temp -'A';
                    sb.append(list.get(n));
                }else if(temp>='a'&& temp <= 'z'){
                    int n = temp -'a';
                    sb.append(Character.toLowerCase(list.get(n)));
                } else{
                    sb.append(tarStr.charAt(i));
                }
            }
            System.out.println(sb.toString());

        }
    }
}

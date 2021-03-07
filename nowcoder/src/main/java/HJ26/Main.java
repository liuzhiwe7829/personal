package HJ26;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/613:56
 *
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 */
public class Main {
    public  static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            StringBuffer sb =new StringBuffer();
            List<Character> letters = new ArrayList<>(str.length());
            for(Character c :str.toCharArray()){
                if(Character.isLetter(c)){
                    letters.add(c);
                }
            }
            letters.sort(Comparator.comparingInt(Character::toLowerCase));
            int i=0;
            for (Character c:str.toCharArray()) {
                //非字母
                if(!Character.isLetter(c)){
                    sb.append(c);
                }else{
                    sb.append(letters.get(i++));
                }

            }
            System.out.println(sb.toString());
        }
    }
}

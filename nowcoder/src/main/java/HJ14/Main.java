package HJ14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/611:57
 *
 * 给定n个字符串，请对n个字符串按照字典序排列。
 */
public class Main {
    public  static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = Integer.parseInt(in.nextLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String next = in.nextLine();
                list.add(next);
            }
            Collections.sort(list);
            list.forEach(s -> System.out.println(s));
        }
    }

}

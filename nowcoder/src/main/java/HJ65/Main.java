package HJ65;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/718:00
 */
public class Main {
    public static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.nextLine();
            String str2 = in.nextLine();

            if(str1.length()>str2.length()){
                String temp = str2;
                str2 = str1;
                str1 = temp;
            }
            List<String> list = new LinkedList<>();
            for(int i =0 ;i<=str1.length()-1;i++){
                for(int j =str1.length()-1;j>i;j--){
                    String temp =str1.substring(i,j);
                    if(str2.contains(temp)){
                        list.add(temp);
                    }
                }
            }
            String res = "";
            for(int i =0 ;i<list.size();i++){
                if(list.get(i).length()>res.length()){
                    res =list.get(i);
                }
            }
            System.out.println(res);
        }

    }
}

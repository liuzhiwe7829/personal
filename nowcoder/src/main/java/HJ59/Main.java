package HJ59;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/712:24
 */
public class Main {
    public static void  main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            Map<Character,Integer> map = new LinkedHashMap<>();
            for(Character c :str.toCharArray()){
                if(map.get(c)!=null){
                    int temp = map.get(c);
                    map.put(c,temp+1);
                }else {
                    map.put(c,1);
                }
            }
            boolean flag =true;
            for (Character key: map.keySet()) {
                if(map.get(key)==1){
                    System.out.println(key);
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("-1");
            }

        }
    }
}

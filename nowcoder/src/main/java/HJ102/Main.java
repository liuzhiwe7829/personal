package HJ102;

import java.util.*;

/**
 * @author zhiwei.liu003
 * @date 2021/3/321:56
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Map<Character, Integer> map = new TreeMap<Character, Integer>(new Comparator<Character>() {
                public int compare(Character o1, Character o2) {
                    return o1.compareTo(o2);
                }
            });
            String str = in.nextLine();
            char[] chars = str.toCharArray();
            for(int i = 0 ;i< chars.length;i++){
                char temp = chars[i];
                if(map.keySet().contains(temp)){
                    int num = map.get(temp);
                    map.put(temp,num+1);
                }else{
                    map.put(temp,1);
                }
            }
            //次数排序
            ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            // key 排序
//            map = new TreeMap<Character, Integer>(map);
            display(list);
        }
    }

    private static void display(ArrayList<Map.Entry<Character, Integer>> list) {
        for (Map.Entry<Character, Integer> g: list) {
//            System.out.print(g.getKey()+" "+g.getValue());
            System.out.print(g.getKey());
        }
        System.out.println();
    }


}

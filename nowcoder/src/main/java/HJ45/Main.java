package HJ45;

import java.util.*;

/**
 * @author zhiwei.liu003
 * @date 2021/3/619:15
 */
public class Main {
    public static void main(String [] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            String[] str = new String[n];
            for(int i = 0 ;i <n;i++){
                str[i] = in.next();
                System.out.println(score(str[i]));
            }
        }
    }
    private static int score(String str) {
        Map<Character,Integer> map = new TreeMap<>();
        int score=0;
        for(int i =0 ;i<str.length();i++){
            char temp = str.charAt(i);
           if(map.get(temp)!=null){
               int num = map.get(temp);
               map.put(temp,num+1);
           }else{
               map.put(temp,1);
           }
        }
        //map 排序
        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>();
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int max = 26;
        for(Map.Entry<Character, Integer> c :list){
            score+=c.getValue()*max;
            max--;
        }
        return score;
    }
}

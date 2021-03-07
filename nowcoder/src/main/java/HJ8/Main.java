package HJ8;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author zhiwei.liu003
 * @date 2021/3/611:30
 */
public class Main {
    public  static  void main(String args[]){
        Scanner in = new Scanner(System.in);
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int n = in.nextInt();
        for(int i = 0 ;i< n;i++){
            int key = in.nextInt();
            int value = in.nextInt();
            if(map.get(key)!=null){
                int temp = map.get(key)+value;
                map.put(key,temp);
            }else{
                map.put(key,value);
            }
        }
        for(int key:map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
    }
}

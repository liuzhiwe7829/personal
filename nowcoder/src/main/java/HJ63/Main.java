package HJ63;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/716:57
 */
public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
            String str = "AAATCACGGAGAAACCAGGTCAGCTGTCTTTACCTCGC";
            int n = 19;
            Map<Integer, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < str.length() - n; i++) {
                String temp = str.substring(i, i + n );
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (temp.charAt(j) == 'G' || temp.charAt(j) == 'C') {
                        count++;
                    }
                }
                map.put(i, count);
            }
            int start = 0;
            for (Integer key : map.keySet()) {
                if (map.get(start) < map.get(key)) {
                    start = key;
                }
            }
            System.out.println(str.substring(start,start+n));
        }
    }

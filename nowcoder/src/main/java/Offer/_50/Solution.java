package Offer._50;

import java.util.HashMap;
import java.util.LinkedHashMap;

class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap = new LinkedHashMap<>();
        for(Character c:s.toCharArray()){
            if(hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c)+1);
            }else {
                hashMap.put(c,1);
            }
        }
        for(Character c:hashMap.keySet()){
            if(hashMap.get(c)==1){
                return c;
            }
        }
        return ' ';
    }
}
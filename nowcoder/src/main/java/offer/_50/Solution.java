package Offer._50;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public char firstUniqChar(String s) {
        List<Character> list = new LinkedList<>();
        for(Character c :s.toCharArray()){
            if(list.contains(c)){
                list.remove(c);
            }else {
                list.add(c);
            }
        }
        return  list!=null?list.get(0):' ';
    }
}
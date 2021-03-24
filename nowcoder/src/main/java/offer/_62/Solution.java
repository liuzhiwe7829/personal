package offer._62;

import java.util.ArrayList;

class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list =new ArrayList<>();
        for(int i=0 ;i< n ;i++){
            list.add(i);
        }
        int index =0;
        while (n>1){
            // 0 1 2 3 / 2
            index = (index+m-1)%n;
            list.remove(index);
            n--;
        }
        return  list.get(0);
    }
}
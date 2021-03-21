package Offer._61;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isStraight(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int max = 14;
        int min = 1;
        for(int i = 0 ;i < nums.length;i++){
            if(nums[i]==0) {
                continue;
            }
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
            if(set.contains(nums[i])) {
                return false ;
            }
            set.add(nums[i]);
        }
        return max -min <5;
    }
}
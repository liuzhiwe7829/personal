package offer._03;

import java.util.*;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length-1;i++ ){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
            if(set.contains(nums[i])){
                return  nums[i];
            }else {
                set.add(nums[i]);
            }

        }
        return -1;
    }
}
package Offer._57;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || target < 0) {
            return new int[0];
        }
        int[] res = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                res[0] = nums[start];
                res[1] = nums[end];
                return res;
            } else if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            }
        }
        return res;
    }

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (i <= target / 2) {
            if (sum < target) {
                //右界右移
                sum += j;
                j++;
            } else if (sum > target) {
                //左界右移
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                //左边界右移
                sum -= i;
                i++;
            }

        }
        return res.toArray(new int [res.size()][]);
    }
}
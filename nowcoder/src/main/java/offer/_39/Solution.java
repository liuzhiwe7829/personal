package offer._39;

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        quickSort(nums,0,nums.length-1);
//        return  nums[nums.length/2];
        int temp = nums[0];
        int count = 0;
        for (int i =0 ;i<nums.length;i++){
            if(temp == nums[i]){
                count++;
            }else {
                count--;
            }
            if(count ==0 ){
                count = 1;
                temp = nums[i];
            }
        }
        return  temp;

    }



    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}
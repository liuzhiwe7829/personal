package Offer._56;

class Solution {
    public int[] singleNumbers(int[] nums) {
        int k =0;
        for(int num:nums){
            k ^=num;
        }
        int mask =1;
        while((k&mask)==0){
            mask=mask<<1;
        }
        int a =0,b =0;
        for(int num:nums){
            if((num& mask)==0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return  new int[]{a,b};
    }

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
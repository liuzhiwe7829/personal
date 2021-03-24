package offer._15;

public class Solution {

    public static void main(String[] args){
        System.out.println(hammingWeight(5));
    }
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
//        int count = Integer.bitCount(n);
//        System.out.println(Integer.bitCount(n));
        int count = 0;
//        while (n!=0){
//            count++;
//            n= n&(n-1);
//        }

//        while(n!=0){
//            if(n%2==1){
//                count++;
//            }
//            n=n>>1;
//        }
        String bit = "00000000000000000000000000001011";
        for(int i= 0 ;i< bit.length();i++){
            if('1'==(bit.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
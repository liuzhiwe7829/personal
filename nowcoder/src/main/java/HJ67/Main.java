package HJ67;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/822:41
 */
public class Main {
    public static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int [] nums = new int[4];
            int [] signs = new int[4];
            for(int i = 0 ; i< 4;i++){
                nums[i] = in.nextInt();
            }
            boolean flag = false;
            for(int i = 0 ;i<nums.length;i++){
                signs[i]=1;
                if(dfs(nums,signs,nums[i],24)){
                    flag = true;
                    break;
                }
                signs[i]=0;
            }
            System.out.println(flag);
        }
    }

    private static boolean dfs(int[] nums, int[] signs, int num, int i) {
        return  false;
    }
}

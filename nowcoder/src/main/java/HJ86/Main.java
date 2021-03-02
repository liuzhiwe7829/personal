package HJ86;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/223:13
 *
 * 题目描述
 * 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 *
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * 输入一个byte数字
 *
 * 输出描述:
 * 输出转成二进制之后连续1的个数
 *
 * 示例1
 * 输入
 * 复制
 * 3
 * 5
 * 输出
 * 复制
 * 2
 * 1
 */
public class Main {
    public  static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int param = in.nextInt();
            String byteString = Integer.toBinaryString(param);
            String [] byteStr = byteString.split("0");
            int count = 0;
            for(String str:byteStr){
                count=Math.max(count,str.length());
            }
            System.out.println(count);

        }
    }
}

package HJ71;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/423:53
 *
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 * ？：匹配1个字符
 *
 *
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 *
 *
 * 输出：
 *
 * 返回匹配的结果，正确输出true，错误输出false
 *
 * 本题含有多组样例输入！
 * 输入描述:
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 *
 * 输出描述:
 * 返回匹配的结果，正确输出true，错误输出false
 *
 * 示例1
 * 输入
 * 复制
 * te?t*.*
 * txt12.xls
 * 输出
 * 复制
 * false
 */
public class Main {
    public  static  void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s1=in.nextLine();
            String s2=in.nextLine();
            System.out.println(comp(s1,s2,0,0));
        }

    }

    private static boolean comp(String s1, String s2, int i, int j) {
        if(s1.length()==i&& s2.length()==j){
            return true;
        }else if(s1.length()==i|| s2.length()==j){
            return false;
        }
        // * 各跳1 || s2跳1
        if(s1.charAt(i)=='*'){
            return  comp(s1,s2,i,j+1)||comp(s1,s2,i+1,j+1);
        } else if(s1.charAt(i)=='?'|| s2.charAt(i)==s1.charAt(i)){
            return  comp(s1,s2,i+1,j+1);
        }else {
            return false;
        }
    }
}

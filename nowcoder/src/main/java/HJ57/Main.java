package HJ57;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/711:07
 */
public class Main {
    public  static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str1=in.nextLine().trim();
            String str2=in.nextLine().trim();
            StringBuffer sb1 = new StringBuffer(str1).reverse();
            StringBuffer sb2 = new StringBuffer(str2).reverse();
            StringBuffer res=calc(sb1,sb2);
            System.out.println(res.reverse().toString());
        }
    }

    private static StringBuffer calc(StringBuffer sb1, StringBuffer sb2) {
        int len1=sb1.length();
        int len2=sb2.length();
        StringBuffer res =new StringBuffer();
        if(len1==len2){
            int flag =0;
            for(int i =0 ;i<sb1.length();i++){
                int sum = sb1.charAt(i)-'0'+sb2.charAt(i)-'0'+flag;
                //进制清零
                flag =0;
                int split=sum;
                if(sum>=10){
                    split= sum%10;
                    flag=sum/10;
                }
                res.append(split);
            }
            if(flag!=0){
                res.append(1);
            }
        }else if(len1<len2){
            res =notEq(sb1,sb2);
        }else if(len1>len2){
            res= notEq(sb2,sb1);
        }
        return res;
    }

    private static StringBuffer notEq(StringBuffer sb1, StringBuffer sb2) {
        StringBuffer res =new StringBuffer();
        int flag =0;
        for(int i =0 ;i<sb1.length();i++){
            int sum = sb1.charAt(i)-'0'+sb2.charAt(i)-'0'+flag;
            //进制清零
            flag =0;
            int split=sum;
            if(sum>=10){
                split= sum%10;
                flag=sum/10;
            }
            res.append(split);
        }
        for(int i = sb1.length();i<sb2.length();i++){
            int sum = sb2.charAt(i)-'0'+flag;
            //进制清零
            flag =0;
            int split=sum;
            if(sum>=10){
                split= sum%10;
                flag=sum/10;
            }
            res.append(split);
        }
        return res;
    }
}

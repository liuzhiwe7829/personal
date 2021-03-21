package HJ57;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 ;
        while((str1 = br.readLine())!=null){
            if(str1.equals(" ")){
                continue;
            }
            String str2 = br.readLine();
            StringBuffer sb1 = new StringBuffer(str1.trim()); //注意去掉最后的那个空格，不然会导致出怪
            StringBuffer sb2 = new StringBuffer(str2.trim());
            while(sb1.length() != sb2.length()){ //题目都是正数的加减
                if(sb1.length() > sb2.length()){
                    sb2.insert(0,'0');
                }else{
                    sb1.insert(0,'0');
                }
            }
            str1 = sb1.toString();
            str2 = sb2.toString();
            int j = 0 , jw = 0 ;//个位和十位
            StringBuffer sb3 = new StringBuffer();
            for(int i = sb1.length()-1 ; i>=0;i--){ //
                int a = str1.charAt(i)-'0';//强制数据类型转换
                int b = str2.charAt(i)-'0';
                int c = a+b+jw;
                j = c%10;
                jw = c/10;
                sb3.insert(0,j);
            }
            if(jw>0){
                sb3.insert(0,jw);
            }
            System.out.println(sb3.toString());
        }
        br.close();
    }
}

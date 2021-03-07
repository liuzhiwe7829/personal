package HJ21;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/613:17
 */
public class Main {
    public  static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            char [] chars = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ;i <chars.length;i++){
                char temp = chars[i];
                if(Character.isUpperCase(temp)){
                    if(temp!='Z') {
                        temp = Character.toLowerCase((char) (temp + 1));
                        sb.append(temp);
                    }else {
                        temp = 'a';
                        sb.append(temp);
                    }
                }else
                //小写字母换数字
                if(Character.isLowerCase(temp)){
                    if(temp>='a'&& temp<='c'){
                        sb.append("2");
                    }else if(temp >='d'&& temp<='f'){
                        sb.append("3");
                    }else  if(temp >='g'&& temp<='i'){
                        sb.append("4");
                    }else  if(temp>='j'&& temp<='l'){
                        sb.append("5");
                    }else if(temp>='m'&& temp<='o') {
                        sb.append("6");
                    }else if(temp>='p'&& temp<='s') {
                        sb.append("7");
                    }else if(temp>='t'&& temp<='v') {
                        sb.append("8");
                    }else if(temp>='w'&& temp<='z') {
                        sb.append("9");
                    }
                }else {
                    sb.append(temp);
                }
            }
            System.out.println(sb.toString());
        }
    }
}

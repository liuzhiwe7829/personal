package HJ74;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/319:26
 */
public class Main {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            String str= in.nextLine();
//            int count =0;
//            int quotationCount = 0;
//            StringBuffer sb=new StringBuffer();
//            for(int i =0 ;i <str.length();i++){
//                char ch = str.charAt(i);
//                //处理引号
//                if(ch == '\"'){
//                    quotationCount++;
//                    continue;
//                }
//                if(ch !=' '){
//                    sb.append(ch);
//                }
//                if(ch == ' '){
//                    //引号内部空格
//                    if(quotationCount %2 == 1){
//                        sb.append(' ');
//                    }
//                    //引号外空格
//                    if(quotationCount%2 ==0){
//                        sb.append("\n");
//                        count++;
//                    }
//                }
//            }
//            System.out.println(count+1);
//            System.out.println(sb.toString());
//        }
//    }

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str= in.nextLine();
            int count =0;
            StringBuffer sb=new StringBuffer();
            //
            int quotation = 0 ;
            for(int i =0 ;i <str.length();i++){
                char ch = str.charAt(i);
                //引号替换
                if(ch== '\"'){
                    quotation++;
                    continue;
                }
                if(ch!=' '){
                    sb.append(ch);
                }
                if(ch == ' '){
                    if(quotation%2 ==1){
                        sb.append(" ");
                    }
                    if(quotation%2 ==0){
                        sb.append('\n');
                        count++;
                    }
                }
            }
            System.out.println(count+1);
            System.out.println(sb.toString());
        }
    }
}

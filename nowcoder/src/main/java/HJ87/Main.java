package HJ87;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/221:43
 */
public class Main {

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int score = 0;
            String param = in.nextLine();
            score= length_cal(param,score);
            score= number_char_cal(param,score);
            display(score);
        }
    }

    /**
     * >= 90: 非常安全
     *
     * >= 80: 安全（Secure）
     *
     * >= 70: 非常强
     *
     * >= 60: 强（Strong）
     *
     * >= 50: 一般（Average）
     *
     * >= 25: 弱（Weak）
     *
     * >= 0:  非常弱
     * @param score
     */
    private static void display(int score) {
        if(score>=90){
            System.out.println("VERY_SECURE");
        }else if(score>=80 && score<90){
            System.out.println("SECURE");
        }else if(score>=70 && score<80){
            System.out.println("VERY_STRONG");
        }else if(score>=60 && score<70){
            System.out.println("STRONG");
        }else if(score>=50 && score<60){
            System.out.println("AVERAGE");
        }else if(score>=25 && score<50){
            System.out.println("WEAK");
        }else if(score>=0&& score<25){
            System.out.println("VERY_WEAK");
        }

    }

    private static int number_char_cal(String param, int score) {
        char[] chars= param.toCharArray();
        int count_number=0;
        int up_number=0;
        int low_number=0;
        int char_number=0;
        int len = chars.length;
        for(int i = 0;i < chars.length;i++){
            char ch = chars[i];
            if(Character.isDigit(chars[i])){
                count_number++;
            }else
            if(Character.isUpperCase(chars[i])){
                up_number++;
            }else
            if(Character.isLowerCase(chars[i])){
                low_number++;
            }else if(ch >= 0x21 && ch <= 0x2F ||
                    ch >= 0x3A && ch <= 0x40 ||
                    ch >= 0x5B && ch <= 0x60 ||
                    ch >= 0x7B && ch <= 0x7E){
                char_number++;
            }
        }
        // 数字计算
        if(count_number ==0){
            score+=0;
        }else if(count_number ==1){
            score+=10;
        }else  if(count_number>1){
            score+=20;
        }
        // 字母计算
        if(up_number== len || low_number== len){
            score+=10;
        }else if(up_number!=0){
            score+=20;
        }
        //符号
        if(char_number==1){
            score+=10;
        }else if(char_number>1){
            score+=25;
        }
        //奖励
        if(count_number!=0&&low_number!=0&&up_number!=0&& char_number!=0){
            score+=5;
        }else if(count_number!=0&&(low_number+up_number)!=0&& char_number!=0){
            score+=3;
        }else  if(count_number!=0&&(low_number+up_number)!=0&& char_number==0 )
        {
            score+=2;
        }
        return  score;
    }

    private static int length_cal(String param, int score) {
        int len = param.length();
        if(len<=4){
            score+=5;
        }else if(len>=5&& len<=7){
            score+=10;
        }else{
            score+=25;
        }
        return  score;
    }
}

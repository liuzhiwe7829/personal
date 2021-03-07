package HJ40;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/617:37
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            int letterNum=0;
            int spaceNum=0;
            int digNum=0;
            int otherNum=0;
            for(int i= 0; i<str.length();i++){
                char temp = str.charAt(i);
                if(Character.isLetter(temp)){
                    letterNum++;
                }else if(temp ==' '){
                    spaceNum++;
                }else if(Character.isDigit(temp)){
                    digNum++;
                }
                else{
                    otherNum++;
                }
            }
            System.out.println(letterNum);
            System.out.println(spaceNum);
            System.out.println(digNum);
            System.out.println(otherNum);
        }
    }
}

package HW03;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhiwei.liu003
 * @date 2021/3/1417:17
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        String  str="(add 1 (div -7 3))";
//        str = str.replaceAll("mul","*");
//        str = str.replaceAll("div","/");
//        str = str.replaceAll("sub","-");
//        str = str.replaceAll("add","+");
//        System.out.println(str);
        Stack<String> ops= new Stack<String>();
        Stack<Integer> vals= new Stack<Integer>();
        int paramA = 0;
        int paramB = 0;
        int mark = 0;
        for(int i =0 ;i < str.length();i++){
            if('('== str.charAt(i)){
                ops.push(str.substring(i+1,i+4));
                i=i+4;
                mark = i+1;
            }else if(')' == str.charAt(i)){
                if(mark<i){
                    vals.push(Integer.parseInt(str.substring(mark,i)));
                    i++;
                    mark=i+1;
                }
                paramA = vals.pop();
                paramB = vals.pop();
                switch (ops.pop()){
                    case "add":
                        vals.push(paramA+paramB);
                        break;
                    case "sub":
                        vals.push(paramA-paramB);
                        break;
                    case "mul":
                        vals.push(paramA*paramB);
                        break;
                    case "div":
                        if(paramB==0){
                            System.out.println("error");
                            return;
                        }else {
                            if((paramA/paramB)<0){
                                vals.push((int) Math.floor(paramA/paramB));
                            }else {
                                vals.push(paramA/paramB);
                            }

                            break;
                        }
                }
            }else {
                if(' ' == str.charAt(i)){
                    if(mark < i){
                        vals.push(Integer.parseInt(str.substring(mark,i)));
                        mark=i+1;
                    }
                }
            }
        }
        while (!ops.isEmpty()){
            paramB = vals.pop();
            paramA = vals.pop();

            switch (ops.pop()){
                case "+":
                    vals.push(paramA+paramB);
                    break;
                case "-":
                    vals.push(paramA-paramB);
                    break;
                case "*":
                    vals.push(paramA*paramB);
                    break;
                case "/":
                    if(paramB==0){
                        System.out.println("error");
                        return;
                    }else {
                        if((paramA/paramB)<0){
                            vals.push((int) Math.floor(paramA/paramB));
                        }else {
                            vals.push(paramA/paramB);
                        }
                        break;
                    }
            }

        }
        System.out.println(vals.pop());
        return;
    }

}

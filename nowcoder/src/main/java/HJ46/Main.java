package HJ46;

import java.util.*;

public class Main {


    public  static String substring(String str, int k) {
        StringBuilder res = new StringBuilder();
        for (char ch : str.toCharArray()) {
            //非汉字
            if (k > 0 && ch < 256) {
                res.append(ch);
                k--;
            }
            else if (k > 1) {
                res.append(ch);
                k -= 2;
            }
            else {
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int k = Integer.parseInt(in.next());
            String res = substring(str, k);
            System.out.println(res);
        }
    }
}
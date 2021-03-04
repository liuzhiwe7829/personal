package HJ75;

import java.util.Scanner;

/**
 * @author zhiwei.liu003
 * @date 2021/3/311:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            int max = 0;
            String maxStr = "";
            if (str1.length() > str2.length()) {
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            for (int i = 0; i < str1.length(); i++) {
                for (int j = str1.length(); j > i; j--) {
                    if (str2.contains(str1.substring(i, j))) {
                        if (j - i > max) {
                            max = j - i;
                            maxStr = str1.substring(i, j);
                        }
                    }
                }

            }
            System.out.println(max);
//            System.out.println(maxStr);
        }
    }
}



package Offer._58;

class Solution {
    public  static  void main(String [] args){
//        String s ="abcdefg";
//        int n = 2;
//        System.out.println(reverseLeftWords(s,2));

        String s ="a good   example";
        System.out.println(reverseWords(s));
    }
    public static String reverseLeftWords(String s, int n) {
        String strA = s.substring(0,n);
        String strB =s.substring(n,s.length());
        return strB+strA;
    }
    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        if(s==null) {
            return null;
        }
        String [] array = s.split(" ");

        for(int i = array.length-1;i>-1;i--){
            if(array[i].equals("")){
                continue;
            }
            sb.append(array[i]);
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
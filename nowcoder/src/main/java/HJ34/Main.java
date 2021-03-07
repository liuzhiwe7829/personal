package HJ34;

import java.util.*;

/**
 * @author zhiwei.liu003
 * @date 2021/3/614:14
 */
public class Main {
    public  static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            List<Character> list = new ArrayList<>();
            for (Character c:str.toCharArray()) {
                list.add(c);
            }
            Collections.sort(list, Character::compareTo);
            StringBuffer sb= new StringBuffer();
            for(int i=0 ;i<list.size();i++){
                sb.append(list.get(i));
            }
            System.out.println(sb.toString());

        }
    }
}

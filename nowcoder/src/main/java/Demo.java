import java.util.ArrayList;

/**
 * @author zhiwei.liu003
 * @date 2019/12/2218:10
 */
public class Demo {

        ArrayList<Integer> solve(int n , ArrayList<ArrayList<Integer> inputs){
            ArrayList<Integer> ret = new ArrayList<Integer>();
            BinaryIndexedTree tree(n);
            for(ArrayList<Integer> book :inputs){
                tree.put(book,get(0)-1,-x);
                tree.put(book,get(1) -x);
            }
            return ret;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int ans = 0, x;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    x = sc.nextInt();
                    ans += x;
                }
            }

        }
}

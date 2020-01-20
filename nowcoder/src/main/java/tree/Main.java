package tree;

import java.util.ArrayList;

/**
 * @author zhiwei.liu003
 * @date 2019/12/2218:11
 */
public class Main {

      private  class BinaryIndexedTree {

          private int length;
          private int[] tree;

          public BinaryIndexedTree(int length) {
              this.length = length;
              tree = new int[length + 1];
          }

          public int sum(int index) {
              if (index < 1 && index > length) {
                  throw new IllegalArgumentException("Out of Range!");
              }
              int sum = 0;
              while (index > 0) {
                  sum += tree[index];
                  index -= lowBit(index);
              }
              return sum;
          }

          public void put(int index, int value) {
              if (index < 1 && index > length) {
                  throw new IllegalArgumentException("Out of Range!");
              }
              while (index <= length) {
                  tree[index] += value;
                  index += lowBit(index);
              }
          }

          private int lowBit(int k) {
              return k & (-k);
          }

      }
        ArrayList<Integer> solve(int n, ArrayList<ArrayList<Integer>> inputs) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            BinaryIndexedTree tree = new BinaryIndexedTree(n);
            for (ArrayList<Integer> book : inputs) {
                tree.put(book.get(0), book.get(2));
                tree.put(book.get(1) + 1, -book.get(2));
            }
            for (int i = 0; i < n; ++i) {
                System.out.println(tree.sum(i));
            }
            return ret;
        }

        public  void main(String[] args) {
            BinaryIndexedTree tree = new Main().new BinaryIndexedTree(5 + 10);
            tree.put(1, 10);
        }
    }
}


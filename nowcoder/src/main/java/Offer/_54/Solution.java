package Offer._54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        if(root == null ) {
            return  0;
        }
        pre(root);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
     return  list.get(k-1);
    }

    private void pre(TreeNode root) {
        if(root.left!=null) {
            pre(root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            pre(root.right);
        }
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
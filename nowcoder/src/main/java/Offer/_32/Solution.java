package Offer._32;

import java.util.*;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> List  = new ArrayList<>();
        if(root == null) {
            return  new ArrayList<>();
        }
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> dd = new LinkedList<>();
            int count = queue.size();
            for(int n = count;n>0;n--){
                TreeNode temp =queue.poll();

                if(temp.left!=null) {
                    dd.add(temp.left);
                }
                if(temp.right!=null){
                    dd.add(temp.right);
                }
                list.add(temp.val);
            }
            queue = dd;
            List.add(list);
        }
        return List;
    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
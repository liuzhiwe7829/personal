package Offer._55;

import java.util.LinkedList;
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
    public int maxDepth(TreeNode root) {
        //DFS
        if(root == null) {
            return  0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

//        BFS
//        if(root == null) {
//            return  0;
//        }
//        List<TreeNode>  queue = new LinkedList(),temp;
//
//        queue.add(root);
//        int res = 0;
//        if(!queue.isEmpty()){
//             temp = new LinkedList<>();
//             for (TreeNode treeNode: queue){
//                 if(treeNode.left!=null){
//                     temp.add(treeNode.left);
//                 }
//                 if(treeNode.right!=null){
//                     temp.add(treeNode.right);
//                 }
//                 queue =temp;
//                 res++;
//             }
//        }
//        return res;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return  true;
        }
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<2&& isBalanced(root.left)&& isBalanced(root.right);
    }
}

 class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
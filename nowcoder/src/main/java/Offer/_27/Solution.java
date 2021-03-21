package Offer._27;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public TreeNode mirrorTree(TreeNode root) {
        //DFS
        Stack<TreeNode> stack = new Stack<>();
        if(root ==null){
            return null;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            //出
            TreeNode treeNode = stack.pop();
            TreeNode left = treeNode.left;
            treeNode.left=treeNode.right;
            treeNode.right=left;
            if(treeNode.left!=null){
                stack.add(treeNode.left);
            }
            if(treeNode.right!=null){
                stack.add(treeNode.right);
            }
        }
     return  root;
    }
//    public TreeNode mirrorTree(TreeNode root) {
//        //BFS
//        Queue<TreeNode> queue = new LinkedList<>();
//        if(root ==null){
//            return null;
//        }
//        queue.add(root);
//        while(!queue.isEmpty()){
//            TreeNode treeNode = queue.poll();
//            TreeNode left = treeNode.left;
//            treeNode.left=treeNode.right;
//            treeNode.right=left;
//            if(treeNode.left!=null){
//                queue.add(treeNode.left);
//            }
//            if(treeNode.right!=null){
//                queue.add(treeNode.right);
//            }
//        }
//        return  root;
//    }

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
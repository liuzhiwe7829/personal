package Offer._28;

import java.util.LinkedList;
import java.util.Queue;

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
    public boolean isSymmetric(TreeNode root) {
        if(root ==null ) {
            return true;
        }

        return  compare(root.left,root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if(left==null && right!=null) {
            return  false;
        } else if(left!=null && right==null) {
            return false;
        } else if(left==null && right==null) {
            return true;
        } else if(left.val!=right.val) {
            return false;
        }
        //节点都不为空
        boolean outside = compare(left.left,right.right);
        boolean inside =compare(left.right,right.left);
        return  outside&& inside;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
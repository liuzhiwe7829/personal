package Offer._68;

import java.util.ArrayList;
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
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root==null){
//            return  null;
//        }
//        if(root == p ||root == q){
//            return  root;
//        }
//
//        TreeNode left =lowestCommonAncestor(root.left,p,q);
//        TreeNode right = lowestCommonAncestor(root.right,p,q);
//        //左右
//        if(left!=null &&right!=null){
//            return  root;
//        }
//        //都在左
//        if(left!=null){
//            return left;
//        }
//        //都在右
//        if(right!=null){
//            return right;
//        }
//        return null;
//    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1= new ArrayList<>();
        List<TreeNode> path2= new ArrayList<>();
        getPath(root,p,path1);
        getPath(root,q,path2);
        TreeNode result = null;
        int n =Math.min(path1.size(),path2.size());
        for(int i = 0 ;i<n;i++){
            if(path1.get(i)==path2.get(i)){
                result =path1.get(i);
            }
        }
        return result;
    }

    private void getPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if(root==null){
            return;
        }
        path.add(root);
        if(root ==node){
            return;
        }
        if(path.get(path.size()-1)!=node){
            getPath(root.left,node,path);
        }
        if(path.get(path.size()-1)!=node){
            getPath(root.right,node,path);
        }
        if(path.get(path.size()-1)!=node){
            path.remove(path.size()-1);
        }
    }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
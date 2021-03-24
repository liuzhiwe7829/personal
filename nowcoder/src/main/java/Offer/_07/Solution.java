package Offer._07;

import java.util.HashMap;

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
    // 索引map
    HashMap<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for(int i = 0 ;i< n;i++){
            indexMap.put(inorder[i],i);
        }
        return  buildMyTree(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode buildMyTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left>preorder_right){
            return null;
        }
        // 先序第一个即为root
        int preorder_root =preorder_left;
        //在中序中定位root位置
        int inorder_root = indexMap.get(preorder[preorder_root]);
        //构建root
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //左子树个数
        int inorder_left_size = inorder_root - inorder_left;
        //递归构建子树
        //左
        root.left = buildMyTree(preorder,inorder,preorder_left+1,preorder_left+inorder_left_size,inorder_left,inorder_root-1);
        //右 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildMyTree(preorder,inorder,preorder_left+inorder_left_size+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }
}

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
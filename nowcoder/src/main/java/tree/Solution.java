package tree;

/*public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 
    public TreeNode(int val) {
        this.val = val;
 
    }
 
}*/
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = TreeDepth(root.left);
        }
        if (root.right != null) {
            right = TreeDepth(root.right);
        }
        return left > right ? left + 1 : right + 1;
    }
}

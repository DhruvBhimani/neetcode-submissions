/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int k1;
    public int kthSmallest(TreeNode root, int k) 
    {
        if(root == null) return ans;
        k1 = k;
        
        return traverse(root);

    }
    int traverse(TreeNode root)
    {
        if(root == null) return ans;
        
        if(root.left != null) traverse( root.left);

        k1--;
        if(k1 == 0) 
        {
            return root.val;
        }
        if(root.right != null) traverse( root.right);

        return ans;
    }
}

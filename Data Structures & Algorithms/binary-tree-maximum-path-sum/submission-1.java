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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        height(root);

        return ans;
    }
    int height(TreeNode root)
    {
        if(root == null) return 0;

        int left = height(root.left) ;
        int right = height(root.right) ;

        left = Math.max(0 ,left);
        right = Math.max(0,right);

        int dia = left + right + root.val ;
        ans = Math.max(ans,dia);

        return Math.max(left,right) + root.val;
    }
}

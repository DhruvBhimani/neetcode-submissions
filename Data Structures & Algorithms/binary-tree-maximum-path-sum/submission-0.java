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
        if(root == null) return ans;

        height(root);

        return ans;
    }
    int height(TreeNode root)
    {
        if(root == null) return 0;

        int left = Math.max(0,height(root.left)) ;
        int right = Math.max(0,height(root.right)) ;

        int dia = left + right + root.val ;
        ans = Math.max(ans,dia);

        return Math.max(left,right) + root.val;
    }
}

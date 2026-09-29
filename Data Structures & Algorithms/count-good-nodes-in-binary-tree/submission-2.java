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
    int count =0;
    public int goodNodes(TreeNode root) 
    {
        if(root == null) return 0;

        return isvalid(root, Integer.MIN_VALUE);
    }
    int isvalid(TreeNode root , int max)
    {
        //if(root == null) return count;

        if(root.val >= max) count++;

        if(root.left != null) isvalid(root.left, Math.max(root.val, max) );
        if(root.right != null) isvalid(root.right, Math.max(root.val, max) );  

        return count;
    }
}
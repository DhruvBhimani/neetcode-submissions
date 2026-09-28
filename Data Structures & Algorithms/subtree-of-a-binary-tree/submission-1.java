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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        if(root == null ) return false;
        if(subRoot == null) return true;

        return is(root, subRoot);
        
        
    }
    boolean is(TreeNode root, TreeNode subRoot)
    {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return is( root.left ,  subRoot) || is( root.right ,  subRoot);

        return is( root.left ,  subRoot.left) && is( root.right ,  subRoot.right);
    }
}

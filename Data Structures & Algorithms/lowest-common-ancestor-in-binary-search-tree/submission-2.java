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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {

        //nno need to look down if we fount q or q
        if(root == null || p==root || q==root) return root;
        
        if((root.left == p && root.right ==q )|| (root.left == q && root.right ==p ))
        {
            return root;
        }

        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);

        if(left != null && right != null) return root;

        //if left or right one is null means its on the side where we stopen checking so return that not itself
        return (left == null) ? right : left; 
    }
}
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
    public TreeNode buildTree(int[] pre, int[] in) 
    {
        if(pre.length == 0) return null;

        int root = pre[0];
        int index = 0;

        for(int i = 0 ; i< in.length ; i++)
        {
            if(in[i]== root)
            {
                index = i;
            }
        }

        TreeNode node = new TreeNode(root);

        node.left =  buildTree(  Arrays.copyOfRange(pre, 1,index + 1)                ,         Arrays.copyOfRange(pre,0, index)   );
        node.right = buildTree(  Arrays.copyOfRange(pre,index + 1 , pre.length)     ,    Arrays.copyOfRange(pre,index + 1 , pre.length)  );

        return node;
    }
}

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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        if(root == null) return result;
        q.offer(root);

        while(!q.isEmpty())
        {
            int lvlsize = q.size();
            TreeNode crrnt = null;
            
            for(int i = 0 ; i<lvlsize;i++)
            {
                crrnt = q.poll();
                if(crrnt.left != null)
                {
                    q.add(crrnt.left);
                }
                if(crrnt.right != null)
                {
                    q.add(crrnt.right);
                }
            }
            result.add(crrnt.val);
        }
        return result;

    }
}

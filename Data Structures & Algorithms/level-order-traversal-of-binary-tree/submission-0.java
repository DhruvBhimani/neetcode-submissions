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

class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if(root == null) return result;
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int lvlsize = queue.size();
            List<Integer> crrntnode = new ArrayList<>();

            for(int i = 0 ; i<lvlsize ; i++)
            {
                TreeNode tmp = queue.poll();
                crrntnode.add(tmp.val);
                if(tmp.left != null)
                {
                    queue.offer(tmp.left);
                }
                if(tmp.right != null)
                {
                    queue.offer(tmp.right);
                }
            }
            result.add(crrntnode);
        }
        return result;
    }
}

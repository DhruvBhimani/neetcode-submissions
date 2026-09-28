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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        if(root == null) return ans;

        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> crrnt = new ArrayList<>(q.size());
            
            for(int i = 0 ; i< size ; i++)
            {
                TreeNode node = q.poll();

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

                crrnt.add(node.val);

            }
            ans.add(crrnt);
        }
        
        
        return ans;


    }
}

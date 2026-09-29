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
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public int goodNodes(TreeNode root) 
    {
        if(root == null) return 0;

        return isvalid(root, Integer.MIN_VALUE);
    }
    int isvalid(TreeNode root , int max)
    {
        if(root == null) return count;

        if(root.val >= max) count++;

        if(root.left != null) 
        {
            maxHeap.offer(root.val);
            isvalid(root.left,  maxHeap.peek());
        }
        if(root.right != null) 
        {
            maxHeap.offer(root.val);
            isvalid(root.right, maxHeap.peek());
        }

        maxHeap.remove(root.val);
        return count;
    }
}

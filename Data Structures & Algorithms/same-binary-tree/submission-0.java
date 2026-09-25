class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        if (p == null && q == null) return true;
        
        if (p == null || q == null) return false;
        
        if (p.val != q.val) return false;

        boolean leftMatches = isSameTree(p.left, q.left);
        boolean rightMatches = isSameTree(p.right, q.right);
        
        return leftMatches && rightMatches;
    }
}
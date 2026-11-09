class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row : dp)
        {
            java.util.Arrays.fill(row,-1);
        }

        return helper(text1.length(),text2.length(),text1,text2 , dp);
    }
    private int helper(int indx1, int indx2 ,String text1, String text2 , int[][] dp)
    {
        if(indx1 == 0 || indx2 == 0) return 0;

        if(dp[indx1][indx2] != -1) return dp[indx1][indx2];

        if(text1.charAt(indx1-1) == text2.charAt(indx2-1))
        {
            return dp[indx1][indx2] = 1 + helper(indx1-1,indx2-1,text1,text2 ,dp);
        }

        return dp[indx1][indx2] = 0 + Math.max(helper(indx1-1 , indx2 , text1 , text2 , dp) , helper(indx1 , indx2-1 , text1 , text2 , dp));
    }
}

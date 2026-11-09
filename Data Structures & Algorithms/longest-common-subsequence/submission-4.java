class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ; i <= n; i++) dp[i][0] = 0;
        for(int i = 0 ; i <= m; i++) dp[0][i] = 0;

        for(int indx1 = 1 ; indx1 <= n ; indx1++)
        {
            for(int indx2 = 1 ; indx2 <= m ; indx2++)
            {
                if(text1.charAt(indx1-1) == text2.charAt(indx2-1))
                {
                    dp[indx1][indx2] = 1 + dp[indx1-1][indx2-1];
                }

                else dp[indx1][indx2] = 0 + Math.max(dp[indx1-1][indx2], dp[indx1][indx2-1]);
            }
        }

        return dp[n][m];
    }
    
}

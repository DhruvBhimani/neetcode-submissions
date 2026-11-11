class Solution {
    public String longestPalindrome(String s) 
    {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString() );
        
    }
   
    private String longestCommonSubsequence(String text1, String text2) 
    {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ; i <= n; i++) dp[i][0] = 0;
        for(int i = 0 ; i <= m; i++) dp[0][i] = 0;

        int indstore1 =0;
        int indstore2 =0;
        int max=0;

        for(int indx1 = 1 ; indx1 <= n ; indx1++)
        {
            for(int indx2 = 1 ; indx2 <= m ; indx2++)
            {
                if(text1.charAt(indx1-1) == text2.charAt(indx2-1))
                {
                    dp[indx1][indx2] = 1 + dp[indx1-1][indx2-1];

                    int originalStart = n - indx2;
                    int originalEnd = originalStart + dp[indx1][indx2] - 1;
                    
                    if (originalEnd == indx1 - 1 && dp[indx1][indx2] >= max) 
                    {
                        max = dp[indx1][indx2];
                        indstore1 = indx1;
                    }
                    // if(dp[indx1][indx2]>= max)
                    // {
                    //     max = dp[indx1][indx2];
                    //     indstore1 = indx1;
                    //     indstore2 = indx2;
                    // }
                }
                else dp[indx1][indx2] = 0 ;
            }
        }
        char[] ans = new char[max];
        int index = max - 1;

        while(index != -1)
        {
            ans[index] = text1.charAt(indstore1-1);
            index--;
            indstore1--;
        }
        String result = new String(ans);

        return result;
        
    }
    
}


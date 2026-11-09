class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        
        for(int i = 0 ; i <= m; i++) prev[i] = 0;

        for(int indx1 = 1 ; indx1 <= n ; indx1++)
        {
            for(int indx2 = 1 ; indx2 <= m ; indx2++)
            {
                if(text1.charAt(indx1-1) == text2.charAt(indx2-1))
                {
                    curr[indx2] = 1 + prev[indx2-1];
                }

                else curr[indx2] = 0 + Math.max(prev[indx2], curr[indx2-1]);
            }
            prev = curr.clone();
        }

        return prev[m];
    }
    
}

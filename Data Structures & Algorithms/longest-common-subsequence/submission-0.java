class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        return helper(text1.length()-1,text2.length()-1,text1,text2);
    }
    private int helper(int indx1, int indx2 ,String text1, String text2)
    {
        if(indx1 < 0 || indx2 < 0) return 0;

        if(text1.charAt(indx1) == text2.charAt(indx2))
        {
            return 1 + helper(indx1-1,indx2-1,text1,text2);
        }

        return 0 + Math.max(helper(indx1-1 , indx2 , text1 , text2) , helper(indx1 , indx2-1 , text1 , text2));
    }
}

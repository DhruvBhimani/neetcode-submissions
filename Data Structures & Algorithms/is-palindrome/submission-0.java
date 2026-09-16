class Solution 
{
    public boolean isPalindrome(String s) 
    {
        s = s.toLowerCase();
        int max = s.length()-1;

        for(int i = 0 ; i <= max; i++)
        {
            if(!Character.isLetterOrDigit(s.charAt(i)))
            {
                continue;
            }
            else if(!Character.isLetterOrDigit(s.charAt(max)))
            {
                max--;
                i--;
            }
            else if(s.charAt(i) == s.charAt(max))
            {
                max--;
            }
            else if (s.charAt(i) != s.charAt(max))
            {
                return false;
            }
        }
        return true;
    }
}

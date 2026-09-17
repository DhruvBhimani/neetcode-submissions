class Solution {
    public boolean isAnagram(String s, String t) 
    {
        // again 1
        int[] count = new int[26];

        if(s.length() != t.length())
        {
            return false;
        }
        
        for(int i =0 ; i< s.length();i++)
        {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int n : count)
        {
            if(n != 0)
            {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) 
    {
        

        int[] counts = new int[26]; 
        for (char ch : s.toCharArray()) 
        {
            counts[ch - 'a']++; 
        }

        int[] counts2 = new int[26]; 
        for (char ch : t.toCharArray()) 
        {
            counts2[ch - 'a']++; 
        }

        return Arrays.equals(counts, counts2);
        
        // if(counts==counts2)
        // {
        //     return true;
        // }
        // else
        // {
        //     return false;
        // }
    }
}

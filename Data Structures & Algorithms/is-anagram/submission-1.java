class Solution {
    public boolean isAnagram(String s, String t) 
    {
        if(s.length() != t.length())
        {
            return false;
        }
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);

        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2); 
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int max = 0;
        int count = 0;
        Set<Character> d = new HashSet<>();

        for(int i=0;i<s.length();i++)
        {
            if(d.contains(s.charAt(i)))
            {
                d.clear();
            }
            else
            {
                d.add(s.charAt(i));
                count = d.size();
                if(count>max)
                {
                    max=count;
                }
            }
        }
        return max;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        Map<Character,Integer> map = new HashMap<>();
        int l=0,r=0 , ans = 0;

        while(r<s.length())
        {
            if(!map.containsKey(s.charAt(r)) || (map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) < l) )
            {
                map.put(s.charAt(r), r);
                ans = Math.max(ans, r-l+1); 
                r++;
            }
            else
            {
                l = map.get(s.charAt(r))+1;
                map.put(s.charAt(r), r);
                r++;

            }
        }
        return ans;

    }
}

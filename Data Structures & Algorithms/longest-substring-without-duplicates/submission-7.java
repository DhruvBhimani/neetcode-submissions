class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, ans = 0;

        for (int r = 0; r < s.length(); r++)
        {
            char ch = s.charAt(r);

            if (map.containsKey(ch) && map.get(ch) >= l)            // If the character was seen before AND its last position is inside our current window
            {
                l = map.get(ch) + 1;                                // Jump the left pointer straight past the old duplicate
            }
            
            map.put(ch, r);                                         // Always update the character's newest position
            
            ans = Math.max(ans, r - l + 1);                         // Always calculate the maximum window size using (r - l + 1)
        }

        return ans;
    }
}

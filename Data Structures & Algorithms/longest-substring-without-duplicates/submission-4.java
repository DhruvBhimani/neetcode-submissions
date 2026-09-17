class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int max = 0;
        int left = 0;
        
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < s.length(); right++) 
        {
            char current = s.charAt(right);

            if (lastSeen.containsKey(current) && lastSeen.get(current) >= left) 
            {
                // Instantly jump 'left' to sit right after the old duplicate
                left = lastSeen.get(current)+1;
            }
            
            lastSeen.put(current, right);

            max = Math.max(max, right - left+1);
        }

        return max;
    }
}

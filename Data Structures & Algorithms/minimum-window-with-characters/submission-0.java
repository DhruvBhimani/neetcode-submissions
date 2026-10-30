class Solution {
    public String minWindow(String s, String t) 
    {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] hash = new int[256];
        
        int l = 0;                // l = 0
        int r = 0;                // r = 0
        int minLen = Integer.MAX_VALUE; 
        int sIndex = -1;          // sIndex = -1
        int cnt = 0;              // cnt = 0

        for (int i = 0; i < t.length(); i++) 
        {
            hash[t.charAt(i)]++;
        }

        while (r < s.length()) 
        {
            if (hash[s.charAt(r)] > 0) 
            {
                cnt = cnt + 1;
            }

            hash[s.charAt(r)]--;

            while (cnt == t.length()) 
            {
                if (r - l + 1 < minLen) 
                {
                    minLen = r - l + 1;  
                    sIndex = l;          
                }

                hash[s.charAt(l)]++;
                
                if (hash[s.charAt(l)] > 0) 
                {
                    cnt = cnt - 1;
                }
                
                // Move the left pointer forward to shrink the window
                l++; 
            }

            r = r + 1;
        }

        // return sIndex == -1 ? "" : s.substr(sIndex, minLen)
        // Note: Java's substring uses (start, end), so end is (sIndex + minLen)
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}

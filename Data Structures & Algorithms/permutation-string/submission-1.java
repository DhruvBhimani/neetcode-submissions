class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        int[] d = new int[26];

        for(char n : s1.toCharArray())
        {
            d[n-'a']++;
        }

        int right = s1.length();

        for(int left = 0 ; left <= s2.length() - right; left++)
        {
            String meta = s2.substring(left, left + right);
            int[] d1 = new int[26];
            for(char n : meta.toCharArray())
            {
                d1[n-'a']++;
            }
            if(Arrays.equals(d,d1))
            {
                return true;
            }

        }
        return false;
    }
}

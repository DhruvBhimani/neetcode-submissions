class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        Map<List<Integer>, List<String>> d = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++)
        {
            int[] count = new int[26];
            for(char c : strs[i].toCharArray())
            {
                count[c - 'a']++;
            }

            List<Integer> keylist = new ArrayList<>();
            for(int freq : count)
            {
                keylist.add(freq);
            }
            if(!d.containsKey(keylist))
            {
                d.put(keylist , new ArrayList<>());
            }

            d.get(keylist).add(strs[i]);
        }   

        return new ArrayList<> (d.values());  
    }
}

// DB Done (9/10)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        Map<String, List<String>> d = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++)
        {
            int[] count = new int[26];
            for(char s : strs[i].toCharArray())
            {
                count[s - 'a']++;
            }
            
            String key = Arrays.toString(count);

            d.putIfAbsent(key, new ArrayList<>());
            d.get(key).add(strs[i]);
        }
        return new ArrayList<> (d.values()); 
    }
}

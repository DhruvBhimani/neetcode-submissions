class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        Map<Integer,Integer> d = new HashMap<>();


        for(int i = 0 ; i < nums.length ; i ++)
        {
            if(d.containsKey(nums[i]))
            {
                int temp = d.get(nums[i]);
                d.put(nums[i], ++temp);
            }
            else
            {
                d.put(nums[i], 1);
            }
        }
        
         // 2. Put the map entries into a List so we can sort them by value
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(d.entrySet());

        // 3. Sort the list in descending order based on frequency values
        // (b.getValue() - a.getValue()) puts the highest frequency first
        entryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // 4. Create the final result int array of size k
        int[] result = new int[k];

        // 5. Extract the top k keys from our sorted list
        for (int i = 0; i < k; i++) 
        {
            result[i] = entryList.get(i).getKey();
        }
        
        return result;
    }
}

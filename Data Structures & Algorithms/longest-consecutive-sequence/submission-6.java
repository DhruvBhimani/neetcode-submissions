class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        Set<Integer> d = new HashSet<>();
        int count=1;
        int max = 1;
        if (nums.length == 0)
        {
            return 0;
        }
        for(int n : nums)
        {
            d.add(n);
        }

        for(int ele : d)
        {
            if(d.contains(ele-1))
            {
                continue;
            }
            else if (!d.contains(ele-1))
            {
                while(d.contains(ele+1))
                {
                    count++;
                    ele++;
                    if(count>max)
                    {
                        max = count;
                    }
                }
                count = 1;
            }
        }
        return max;
    }
}

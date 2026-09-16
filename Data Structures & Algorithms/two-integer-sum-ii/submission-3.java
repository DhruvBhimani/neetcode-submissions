class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int max = numbers.length-1;
        int i = 0;

        while(i<max)
        {
            int current = numbers[i]+numbers[max];

            if(current == target)
            {
                return new int[]{i+1,max+1};
            }
            else if(current < target)
            {
                i++;
            }
            else
            {
                max--;
            }

        }
        return new int[]{};
    }
}

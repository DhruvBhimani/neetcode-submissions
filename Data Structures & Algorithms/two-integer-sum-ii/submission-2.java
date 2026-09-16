class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int max = numbers.length-1;
        int i = 0;

        while(i<max)
        {
            int need = target - numbers[i];

            if(numbers[max] == need)
            {
                return new int[]{i+1,max+1};
            }
            else
            {
                if(max == i+1)
                {
                    i++;
                    max=numbers.length-1;
                }
                else
                {
                    max--;
                }
                
            }
            
        }
        return new int[]{};
    }
}

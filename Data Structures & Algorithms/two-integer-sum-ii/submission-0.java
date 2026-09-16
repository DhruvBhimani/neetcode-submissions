class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int max = numbers.length-1;

        for(int i=0 ; i< numbers.length;i++)
        {
            int need = target - numbers[i];

            if(numbers[max] == need)
            {
                return new int[]{i+1,max+1};
            }
            else
            {
                if(i<max)
                {
                    max--;
                    i--;
                }
                else
                {
                    continue;
                }
                
            }
        }
        return new int[]{};
    }
}

class Solution {
    public int findMin(int[] nums) 
    {
        if(nums[0]<nums[nums.length-1])
        {
            return nums[0];
        }
        int i = 0 , j = nums.length-1;

        while(i<=j)
        {
            int pivot = (i+j)/2;

            if(nums[pivot]<nums[pivot-1])
            {
                return nums[pivot];
            }
            else if(nums[pivot]<nums[i])
            {
                j=pivot-1;
            }
            else
            {
                i = pivot + 1;
            }
        }

        return -1;
    }
}

class Solution 
{
    public int search(int[] nums, int target) 
    {
       

        int i = 0 , j = nums.length-1;

        while(i<=j)
        {
            int pivot = (i+j)/2;

            if(nums[pivot] == target)
            {
                return pivot;
            }
            // left must be sorted
            if(nums[i]<= nums[pivot])
            {
                if(target < nums[pivot] && target >= nums[i])
                {
                    j= pivot - 1;
                }
                else
                {
                    i = pivot+1;
                }
            }
            // right must be sorted if not left
            else
            {
                if(target > nums[pivot] && target <= nums[j])
                {
                    i= pivot + 1;
                }
                else
                {
                    j = pivot-1;
                }
            }
            
        }
        return -1;

        
    }
}
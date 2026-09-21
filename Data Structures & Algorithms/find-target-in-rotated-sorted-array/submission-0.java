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
            else if(target > nums[j])
            {
                j=pivot-1;
            }
            else if(target < nums[j])
            {
                i=pivot+1;
            }
            
        }
        return -1;

        
    }
}
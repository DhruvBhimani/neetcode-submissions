class Solution {
    public int search(int[] nums, int target) 
    {
        int j = nums.length-1;
        int i =0;
        int pivot = (i+j)/2;
        while(pivot != i && pivot!=j )
        {
            if(target == nums[pivot])
            {
                return pivot;
            }
            else if(target < nums[pivot])
            {
                j = pivot;
                pivot = (i+j)/2;
            }
            else if(target > nums[pivot])
            {
                i = pivot;
                pivot = (i+j)/2;
            }
        }
        return -1;
    }
}

class Solution {
    public int search(int[] nums, int target) 
    {
        if(nums.length<=2)
        {
            if(nums.length == 0)
            {
                return -1;
            }
            else if(nums[0]== target)
            {
                return 0;
            }
            else if ( nums.length>1 && nums[1]==target)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        int j = nums.length-1;
        int i =0;
        int pivot = (i+j)/2;
        while(pivot > i && pivot<j )
        {
            if(target == nums[pivot] || target == nums[i] || target == nums[j])
            {
                if(target == nums[pivot])
                return pivot;
                else if(target == nums[i])
                return i;
                else
                return j;

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

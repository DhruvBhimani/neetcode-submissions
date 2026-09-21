class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        // Using <= allows the pointers to check the very last remaining number
        while (i <= j) 
        {
            int pivot = (i + j) / 2;

            if (nums[pivot] == target) 
            {
                return pivot;
            }
            else if (target < nums[pivot]) 
            {
                j = pivot - 1; 
            }
            else 
            {
                i = pivot + 1; 
            }
        }
        
        return -1; 
    }
}

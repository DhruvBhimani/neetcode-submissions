class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = (rows * cols) - 1;

        while(i<=j)
        {
            int pivot = (i+j)/2;

            int r = pivot / cols; 
            int c = pivot % cols; 

            if(target == matrix[r][c])
            {
                return true;
            }
            else if(target > matrix[r][c])
            {
                i = pivot+1;
            }
            else
            {
                j = pivot-1;
            }
        }

        return false;
    }
}

class Solution 
{
    public int maxArea(int[] heights) 
    {
        int max = heights.length-1;
        int i =0;
        int ans = 0;

        while(i<max)
        {
            int dis = max-i;
            int min = Math.min(heights[i],heights[max]);
            int temp = min * dis;
            if(temp>ans)
            {
                ans=temp;
            }

            if(heights[i+1]>heights[i])
            {
                i++;
            }
            else if(heights[max-1]>heights[max])
            {
                max--;
            }
            else
            {
                i++;
            }
        }
        return ans;
    }
}

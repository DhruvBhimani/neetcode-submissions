class Solution {
    public int trap(int[] height) 
    {
        int maxl = 0, maxr = 0 , ans=0;
        int i = 0, j = height.length-1;

        while(i<=j)
        {
            maxl = Math.max(maxl , height[i]);
            maxr = Math.max(maxr , height[j]);

            if(maxl < maxr)
            {
                if(maxl - height[i] > 0) ans += maxl - height[i];
                i++;
            }
            else
            {
                if(maxr - height[j] > 0) ans += maxr - height[j];
                j--;
            }
        }
        return ans;
    }
}

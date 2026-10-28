class Solution {
    public int trap(int[] height) 
    {
        int maxl = 0, maxr = 0 , ans=0;
        int i = 0, j = height.length-1;

        while(i<=j)
        {
            if(maxl < maxr)
            {
                if(maxl - height[i] > 0) ans += maxl - height[i];
                i++;
                maxl = Math.max(maxl , height[i]);
            }
            else
            {
                if(maxr - height[j] > 0) ans += maxr - height[j];
                j--;
                maxr = Math.max(maxr , height[j]);
            }
        }
        return ans;
    }
}

class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right; // for now max element is result 

        
        while(left<= right)
        {
            int pivot = (left + right)/2;

            int totaltime = 0;
            for(int p : piles)
            {
                totaltime += Math.ceil((double) p / pivot);
            }

            if(totaltime <= h)
            {
                result = pivot;
                right = pivot -1;
            }
            else
            {
                left = pivot + 1;
            }
        }
        return result;

    }
}

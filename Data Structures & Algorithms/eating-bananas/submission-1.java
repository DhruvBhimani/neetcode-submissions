class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        // left to right range is 1 to max number from pile (which is garentied to be answer) and we wanna min  answer from this range 
        int left = 1; // coz 0 means 0 banana per hour 
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right; // for now max element is result 

        
        while(left<= right)
        {
            int pivot = (left + right)/2;

            int totaltime = 0;
            
            for(int p : piles)
            {
                // ceiling coz 5/2 = we want 3 as it will take 3 hours for this pile
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

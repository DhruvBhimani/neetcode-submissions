class Solution {
    public int leastInterval(char[] tasks, int n) 
    {
        int[] count = new int[26];
        for(char c : tasks)
        {
            count[c-'A']++;
        }

        int max = Arrays.stream(count).max().getAsInt();
        // # of times max count appears
        int numMax=0;
        for( int counts : count)
        {
            if(counts == max)
            {
                numMax++;
            }
        }

        int time = (max - 1) * (n + 1) + numMax ;

        return Math.max(time , tasks.length);
    }
}

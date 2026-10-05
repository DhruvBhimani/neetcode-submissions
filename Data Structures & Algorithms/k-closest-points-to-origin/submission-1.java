class Solution {
    public int[][] kClosest(int[][] points, int k) 
    {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        
        for(int i = 0 ; i< points.length ; i++)
        { 
            int tmp1 = points[i][0];
            int tmp2 = points[i][1];

            int dist = (tmp1 * tmp1)+ (tmp2 * tmp2);

            minHeap.offer(new int[]{dist, i});
        }

        int[][] ans = new int[k][2];

        for(int j = 0 ; j<k ; j++)
        {
            int[] currentPair = minHeap.poll();
            
            // currntpair[1] has the i value of points for the smallest
            ans[j] = points[currentPair[1]];
        }

        return ans;
        
    }
}
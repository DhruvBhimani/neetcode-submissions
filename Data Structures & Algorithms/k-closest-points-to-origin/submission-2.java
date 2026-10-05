
class Solution {
    public int[][] kClosest(int[][] points, int k) 
    {
        // 1. Convert to a Max-Heap: Sort by index 0 (distance) in descending order (largest first)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[0]).reversed());
        
        for(int i = 0 ; i < points.length ; i++)
        { 
            int tmp1 = points[i][0];
            int tmp2 = points[i][1];

            int dist = (tmp1 * tmp1) + (tmp2 * tmp2);

            maxHeap.offer(new int[]{dist, i});

            // 2. Optimization Rule: If size goes past k, kick out the largest distance point!
            if (maxHeap.size() > k) 
            {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][2];

        // 3. Fill your answer array backwards or forwards (the remaining items are the absolute k closest)
        for(int j = 0 ; j < k ; j++)
        {
            int[] currentPair = maxHeap.poll();
            ans[j] = points[currentPair[1]];
        }

        return ans;
    }
}

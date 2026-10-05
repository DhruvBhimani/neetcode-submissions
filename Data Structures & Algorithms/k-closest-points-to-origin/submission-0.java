class Solution {
    public int[][] kClosest(int[][] points, int k) 
    {
        // PriorityQueue<Double> minHeap = new PriorityQueue<>();
        TreeMap<Double,Integer[][]> ans = new TreeMap<>();
        for(int i = 0 ; i< points.length ; i++)
        { 
            int tmp1 = points[i][0];
            int tmp2 = points[i][1];

            double dist = Math.sqrt((tmp1 * tmp1)+ (tmp2 * tmp2));

            ans.put(dist, new Integer[][]{ {tmp1, tmp2} } );
            //minHeap.offer(dist);
        }
        int[][] result = new int[k][2];
        int count = 0;

        for (Integer[][] coordinates : ans.values()) 
        {
            if (count >= k) 
            {
                break; 
            }
            result[count][0] = coordinates[0][0];
            result[count][1] = coordinates[0][1];
            
            count++;
        }

        return result;
    }
}
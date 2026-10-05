class Solution {
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums)
        {
            if(minHeap.size()<k)
            {
                minHeap.offer(num);
            }
            else
            {
                minHeap.offer(num);
                minHeap.poll();
            }
            
        }

        return minHeap.peek();
    }
}

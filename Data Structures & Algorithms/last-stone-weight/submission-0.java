class Solution {
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i< stones.length ; i++)
        {
            maxHeap.offer(stones[i]);
        }
        while(maxHeap.size()>=2)
        {
            int tmp1 = maxHeap.poll();
            int tmp2 = maxHeap.poll();

            if(tmp1 == tmp2) continue;
            else maxHeap.offer(tmp1-tmp2);

        }
        if(maxHeap.size() == 1) return maxHeap.peek();

        return 0;
    }
}

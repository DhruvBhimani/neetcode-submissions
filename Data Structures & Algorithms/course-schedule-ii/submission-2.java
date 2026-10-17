class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i< numCourses ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites)
        {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < numCourses ; i++)
        {
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans[i++] = node;

            for(int rm : adj.get(node))
            {
                indegree[rm]--;
                if(indegree[rm] == 0)
                {
                    q.offer(rm);
                }
            }
        }

        return (i == numCourses) ? ans : new int[]{};
    }
}

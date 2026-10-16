class Solution {
    public int countComponents(int n, int[][] edges) 
    {
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i<n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int ans = 0;
        for(int i = 0 ; i< n ; i++)
        {
            if(vis[i] == false)
            {
                DFS(vis,adj,i);
                ans++;
            }
        }
        return ans;

    }
    private void DFS(boolean[] vis , List<List<Integer>> adj , int node)
    {
        vis[node] = true;
        for(int it : adj.get(node))
        {
            if(vis[it] == false)
            {
                DFS(vis,adj,it);
            }
        }
    }
}


class Solution 
{
    public boolean validTree(int n, int[][] edges) 
    {
        if (edges.length != n - 1) 
        {
            return false;
        }

        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) 
        {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) 
        {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
            
        // 1. Traverse the graph starting from node 0
        // If a cycle is detected during DFS, it's not a tree
        if (!dfs(vis, adj, 0, -1)) 
        {
            return false;
        }

        for (boolean visited : vis) 
        {
            if (visited == false) return false;
        }

        return true;
    }

    private boolean dfs(boolean[] vis, List<List<Integer>> adj, int node, int parent) 
    {
        vis[node] = true;

        for (int it : adj.get(node)) 
        {
            if (vis[it] == false) 
            {
                // If a cycle is found deeper down, propagate the false upwards immediately
                if (!dfs(vis, adj, it, node)) 
                {
                    return false;
                }
            } 
            else if (vis[it] == true && it != parent) 
            {
                return false;
            }
        }
        
        return true;
    }
}

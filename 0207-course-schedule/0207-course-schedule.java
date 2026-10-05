class Solution {

    boolean dfs(List<List<Integer>>  adj, boolean[] vis, boolean[] dfs_vis, int node) {
        vis[node] = true;
        dfs_vis[node] = true;

        for (int ele : adj.get(node)) {
            if (vis[ele] == false) {
                if (dfs(adj, vis, dfs_vis, ele) == true) {
                    return true;
                } 
            }else if (dfs_vis[ele] == true) {
                    return true;
                }
        }

        dfs_vis[node] = false;
        return false;
    }

    public boolean canFinish(int n, int[][] prerequisites) {
        boolean[] vis = new boolean[n];
        boolean[] dfs_vis = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            adj.get(prerequisite).add(course);
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                if (dfs(adj, vis, dfs_vis, i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
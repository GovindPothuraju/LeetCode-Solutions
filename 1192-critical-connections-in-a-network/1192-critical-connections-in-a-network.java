class Solution {
    List<List<Integer>> res;
    int[] dt;
    int[] low;
    int time;

    private void dfs(int u, int par, boolean[] visited, List<List<Integer>> adj) {
        dt[u] = low[u] = time++;
        visited[u] = true;

        for (int v : adj.get(u)) {

            if (v == par) continue;

            if (!visited[v]) {
                dfs(v, u, visited, adj);

                // Update low value
                low[u] = Math.min(low[u], low[v]);

                // Bridge condition
                if (low[v] > dt[u]) {
                    res.add(Arrays.asList(u, v));
                }

            } else {
                // Back edge
                low[u] = Math.min(low[u], dt[v]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        res = new ArrayList<>();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dt = new int[n];
        low = new int[n];
        boolean[] visited = new boolean[n];

        time = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, adj);
            }
        }

        return res;
    }
}
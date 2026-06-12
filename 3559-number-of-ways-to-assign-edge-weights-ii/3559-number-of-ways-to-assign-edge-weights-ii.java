class Solution {

    int LOG = 17; // enough for n <= 100000
    int MOD = 1_000_000_007;

    int[][] up;
    int[] depth;
    ArrayList<Integer>[] adj;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        while ((1 << LOG) <= n) LOG++;

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        up = new int[n + 1][LOG];
        depth = new int[n + 1];

        dfs(1, 0);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int lca = getLCA(u, v);

            int dist = depth[u] + depth[v] - 2 * depth[lca];

            ans[i] = (int) modPow(2, dist - 1);
        }

        return ans;
    }

    private void dfs(int node, int parent) {

        up[node][0] = parent;

        for (int j = 1; j < LOG; j++) {
            up[node][j] = up[up[node][j - 1]][j - 1];
        }

        for (int nei : adj[node]) {

            if (nei == parent) continue;

            depth[nei] = depth[node] + 1;

            dfs(nei, node);
        }
    }

    private int getLCA(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = LOG - 1; j >= 0; j--) {
            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {

            if (up[u][j] != up[v][j]) {

                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }

    private long modPow(long base, long exp) {

        long res = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}
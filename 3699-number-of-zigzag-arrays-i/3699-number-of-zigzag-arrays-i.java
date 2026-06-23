class Solution {

    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2 initialization
        for (int a = 0; a < m; a++) {
            for (int b = a + 1; b < m; b++) {
                up[b]++;
                down[a]++;
            }
        }

        if (n == 2) {
            long ans = 0;
            for (int i = 0; i < m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
            return (int) ans;
        }

        for (int len = 3; len <= n; len++) {

            long[] diffUp = new long[m + 1];
            long[] diffDown = new long[m + 1];

            for (int last = 0; last < m; last++) {

                long upVal = up[last];
                long downVal = down[last];

                if (upVal != 0) {
                    // contribute to range [0, last-1]
                    diffDown[0] = (diffDown[0] + upVal) % MOD;

                    if (last < m) {
                        diffDown[last] =
                                (diffDown[last] - upVal + MOD) % MOD;
                    }
                }

                if (downVal != 0) {
                    // contribute to range [last+1, m-1]
                    if (last + 1 < m) {
                        diffUp[last + 1] =
                                (diffUp[last + 1] + downVal) % MOD;
                    }
                }
            }

            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            long running = 0;

            for (int i = 0; i < m; i++) {
                running = (running + diffUp[i]) % MOD;
                nextUp[i] = running;
            }

            running = 0;

            for (int i = 0; i < m; i++) {
                running = (running + diffDown[i]) % MOD;
                nextDown[i] = running;
            }

            up = nextUp;
            down = nextDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i]) % MOD;
            ans = (ans + down[i]) % MOD;
        }

        return (int) ans;
    }
}
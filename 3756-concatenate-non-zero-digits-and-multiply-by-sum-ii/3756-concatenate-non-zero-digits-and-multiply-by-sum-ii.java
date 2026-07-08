class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        int[] nonZero = new int[n + 1];
        int[] sum = new int[n + 1];
        long[] numUpto = new long[n + 1];
        long[] power10 = new long[n + 1];

        power10[0] = 1;
        for (int i = 1; i <= n; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }

        for (int i = 1; i <= n; i++) {

            int digit = s.charAt(i - 1) - '0';

            sum[i] = sum[i - 1] + digit;

            nonZero[i] = nonZero[i - 1];
            if (digit != 0) {
                nonZero[i]++;
            }

            if (digit != 0) {
                numUpto[i] = (numUpto[i - 1] * 10 + digit) % MOD;
            } else {
                numUpto[i] = numUpto[i - 1];
            }
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int digitSum = sum[r + 1] - sum[l];

            int nonZeroDigits = nonZero[r + 1] - nonZero[l];

            long numUptoR = numUpto[r + 1];

            long numBeforeL = (numUpto[l] * power10[nonZeroDigits]) % MOD;

            long x = (numUptoR - numBeforeL + MOD) % MOD;

            res[i] = (int) ((x * digitSum) % MOD);
        }

        return res;
    }
}
class Solution {
    public long findKthSmallest(int[] coins, int k) {

        long low = 1;

        int minCoin = Integer.MAX_VALUE;
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        // k * minimum coin is always a valid upper bound
        long high = (long) minCoin * k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long count = 0;

        // Inclusion-Exclusion using bitmask
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long g = gcd(lcm, coins[i]);

                    // Prevent LCM overflow
                    if (lcm > x / (coins[i] / g)) {
                        lcm = x + 1;
                        break;
                    }

                    lcm = lcm / g * coins[i];
                }
            }

            // No multiple of this LCM can be <= x
            if (lcm > x) {
                continue;
            }

            long ways = x / lcm;

            // Odd number of elements -> add
            // Even number of elements -> subtract
            if (bits % 2 == 1) {
                count += ways;
            } else {
                count -= ways;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
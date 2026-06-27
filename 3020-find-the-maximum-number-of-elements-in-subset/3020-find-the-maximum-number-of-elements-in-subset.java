class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put((long) num, hm.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Special case for 1
        if (hm.containsKey(1L)) {
            int cnt = hm.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for (long key : hm.keySet()) {

            if (key == 1)
                continue;

            long curr = key;
            int ct = 0;

            while (hm.containsKey(curr)) {

                if (hm.get(curr) >= 2) {
                    ct++;
                } else {
                    ct++;
                    break;
                }

                if (curr > Long.MAX_VALUE / curr)
                    break;

                curr = curr * curr;
            }

            ans = Math.max(ans, 2 * ct - 1);
        }

        return ans;
    }
}
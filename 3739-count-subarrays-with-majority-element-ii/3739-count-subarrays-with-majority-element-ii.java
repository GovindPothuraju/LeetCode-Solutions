class BinaryIndexedTree {
    private int n;
    private int[] tree;

    public BinaryIndexedTree(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    public void update(int index, int val) {
        while (index <= n) {
            tree[index] += val;
            index += index & -index;
        }
    }

    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
}

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        BinaryIndexedTree bit = new BinaryIndexedTree(2 * n + 1);

        // Current prefix sum shifted by (n + 1)
        int prefix = n + 1;

        // Initial prefix sum = 0
        bit.update(prefix, 1);

        long ans = 0;

        for (int num : nums) {
            if (num == target)
                prefix++;
            else
                prefix--;

            // Count previous prefix sums < current prefix
            ans += bit.query(prefix - 1);

            // Store current prefix
            bit.update(prefix, 1);
        }

        return ans;
    }
}
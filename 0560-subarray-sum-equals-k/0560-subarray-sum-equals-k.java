class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0, ans = 0;
        hm.put(0, 1); // base case: to handle subarrays starting at index 0

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remaining = sum - k;
            if (hm.containsKey(remaining)) {
                ans += hm.get(remaining);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}

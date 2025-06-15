class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        List<Integer> arr = new ArrayList<>();

        // Keep playing the game while there are elements
        while (!pq.isEmpty()) {
            int aliceElement = pq.poll();
            int bobElement = pq.poll();

            // Bob adds first, then Alice
            arr.add(bobElement);
            arr.add(aliceElement);
        }

        // Convert List<Integer> to int[]
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }

        return result;
    }
}
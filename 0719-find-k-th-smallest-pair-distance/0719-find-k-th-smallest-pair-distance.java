class Solution {
    public int smallestDistancePair(int[] a, int k) {
        Arrays.sort(a);
        int n=a.length;
        int l = 0;
        int r = a[n - 1] - a[0];

        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = countPairs(a, mid);
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static int countPairs(int[] arr, int mid) {
        int count = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            while (arr[right] - arr[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
    
}
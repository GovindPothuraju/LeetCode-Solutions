class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int max = 0;
        // sort the array
        Arrays.sort(arr);
        //replace array values
        if(arr[0] != 1)arr[0]=1;
        for(int i=1;i<n;i++){
            if(Math.abs(arr[i]-arr[i-1]) > 1){
                arr[i]=arr[i-1]+1;
            }
        }
        // find max value;
        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
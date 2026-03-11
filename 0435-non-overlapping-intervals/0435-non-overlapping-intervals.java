class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 1. one method
        // Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        // int n=intervals.length;
        // ArrayList<int[]> arr=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     arr.add(intervals[i]);
        // }
        // System.out.println(Arrays.deepToString(arr.toArray()));
        // int count=0;
        // int i=1;
        // while(i<arr.size()){
        //     if(arr.get(i-1)[1] > arr.get(i)[0]){
        //         arr.remove(arr.get(i));
        //         count++;
        //     }else{
        //         i++;
        //     }
        // }
        // return count;

        // 2nd method
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int n=intervals.length;

        int k=Integer.MIN_VALUE;
        int count=0;

        for(int i=0;i<n;i++){
            if(intervals[i][0] < k){
                count++;
            }else{
                k=intervals[i][1];
            }
        }
        return count;
    }
}
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals , (a,b)->{
            if(a[1]==b[1]){
                return b[0]-a[0];
            }
            return a[1]-b[1];
        });
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=1;i<n;i++){
            int temp = i;
            while(temp > 0 ){
                if(visited[temp]){
                    temp--;
                    continue;
                }
                int a = intervals[temp-1][0];
                int b = intervals[temp-1][1];

                int c = intervals[i][0];
                int d = intervals[i][1];

                if(c<=a && b<=d){
                    count++;
                    visited[temp] = true;
                    System.out.println(Arrays.toString(new int[]{a,b}));
                }
                temp--;
            }
        }
        return n-count;
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int res=1;
        int n=points.length;
        int arrowpos=points[0][1];

        for(int i=1;i<n;i++){
            if(points[i][0] > arrowpos){
                res++;
                arrowpos=points[i][1];
            }
        }
        return res;
    }
}
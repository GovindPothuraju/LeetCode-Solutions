class Solution {
    public double findMaxAverage(int[] arr, int k) {
        double res=Integer.MIN_VALUE;
        int l=0;
        int sum=0;
        for(int r=0;r<arr.length;r++){
            sum+=arr[r];
            if(r-l+1 == k){
                res=Math.max(res,sum);
                sum-=arr[l];
                l++;
            }
        }
        return res/ (double)k;
    }
}
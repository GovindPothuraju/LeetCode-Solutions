class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int maximum=Integer.MIN_VALUE;
        while(l<r){
            int temp=(r-l)*Math.min(height[l],height[r]);
            maximum=Math.max(maximum,temp);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maximum;
    }
}
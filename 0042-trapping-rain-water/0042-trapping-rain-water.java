class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int temp=Integer.MIN_VALUE;
        int trapped=0;
        int[] left_bound=new int[n];
        int[] right_bound=new int[n];
        for(int i=0;i<n;i++){
            temp=Math.max(temp,height[i]);
            left_bound[i]=temp;
        }
        temp=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            temp=Math.max(temp,height[i]);
            right_bound[i]=temp;
        }
        for(int i=0;i<n;i++){
            int water_level=Math.min(left_bound[i],right_bound[i]);
            trapped+=water_level-height[i];
        }
        return trapped;
    }
}
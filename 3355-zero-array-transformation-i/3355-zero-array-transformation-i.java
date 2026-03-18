class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        
        int n=nums.length;
        int[] diff=new int[n];

        for(int[] query : queries){
            int st=query[0];
            int ed=query[1];

            diff[st]+=1;
            if(ed+1 < n)diff[ed+1]-=1;
        }
        for(int i=1;i<n;i++){
            diff[i]+=diff[i-1];
        }
        for(int i=0;i<n;i++){
            if(diff[i] < nums[i]) return false;
        }
        return true;
    }
}
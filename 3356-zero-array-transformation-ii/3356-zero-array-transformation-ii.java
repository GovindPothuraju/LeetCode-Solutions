class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=queries.length;

        int l=0;
        int r=n;
        while(l<=r){
            int mid= l+(r-l)/2;
            if(isPossible(nums,queries,mid)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l>n?-1 : l;
    }
    private boolean isPossible(int[] nums, int[][] queries,int k){
        int n=nums.length;
        int diff[]=new int[n];
        for(int i=0;i<k;i++){
            int[] query=queries[i];

            int st=query[0];
            int end=query[1];
            int x=query[2];

            diff[st]+=x;
            if(end+1 < n) diff[end+1]-=x;
        }
        //prefix sum
        for(int i=1;i<n;i++){
            diff[i]=diff[i-1]+diff[i];
        }

        for(int i=0;i<n;i++){
            if(diff[i]<nums[i])return false;
        }
        return true;
    }
}
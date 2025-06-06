class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] answer=new int[n];
        left[0]=nums[0];
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i];
        }
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i];
        }
        answer[0]=right[1];
        answer[n-1]=left[n-2];
        for(int i=1;i<n-1;i++){
            answer[i]=left[i-1]*right[i+1];
        }
        return answer;
    }
}
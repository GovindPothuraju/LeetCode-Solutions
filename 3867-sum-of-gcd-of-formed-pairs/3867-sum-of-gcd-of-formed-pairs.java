class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;

        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixMax[i] = Math.max(nums[i],prefixMax[i-1]);
        }

        int[] prefixGcd = new int[n];
        for(int i=0;i<n;i++){
            prefixGcd[i] = getGcd(nums[i],prefixMax[i]);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;
        int l=0;
        int r=n-1;
        while(l<r){
            sum += getGcd(prefixGcd[l],prefixGcd[r]);
            l++;
            r--;
        }

        return sum;
    }
    private int getGcd(int a,int b){
        if(b==0)return a;
        return getGcd(b,a%b);
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int result=Integer.MIN_VALUE;
        int n=nums.length;
        /*for(int i=0;i<n;i++){
            int mul=1;
            for(int j=i;j<n;j++){
                mul*=nums[j];
                result=Math.max(result,mul);
            }

        }
        return result;*/
        int maxp=Integer.MIN_VALUE;
        int prefix=1;
        int suffix=1;
        for(int i=0;i<n;i++){
            prefix*=nums[i];
            if(prefix==0){
                prefix=1;
            }
            maxp=Math.max(maxp,prefix);
        }
        for(int i=n-1;i>=0;i--){
            suffix*=nums[i];
            if(suffix==0){
                suffix=1;
            }
            maxp=Math.max(maxp,suffix);
        }
        if(maxp==1){
            return 0;
        }else{
            return maxp;
        }

    }
}
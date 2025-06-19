class Solution {
    public int[] findErrorNums(int[] nums) {
        /*HashSet<Integer> hs = new HashSet<>();
        int n=nums.length;
        int duplicate=-1,missing=-1;
        for(int i=0;i<n;i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
            }else{
                duplicate=nums[i];
            }
        }
        for(int i=1;i<=n;i++){
            if(!hs.contains(i)){
                missing=i;
            }
        }
        int[] res={duplicate,missing};
        return res;*/

        // cycle sort bexz 1:n
        /*int n=nums.length;
        int i=0;
        while(i<n){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }else{
                i++;
            }
        }
        int[] res=new int[2];
        for(i=0;i<n;i++){
            if(nums[i] != i+1){
                res[0]=nums[i];
                res[1]=i+1;
            }
        }
        return res;*/
        // using count sort also
        int n=nums.length;
        int freq[]=new int[nums.length+1];
        int ans[]=new int[2];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
            if(freq[nums[i]]==2){
                ans[0]=nums[i];
            }
        }
        for(int i=1;i<=n;i++){
            if(freq[i]==0){
                ans[1]=i;
                break;
            }
        }
        return ans;
    }
}
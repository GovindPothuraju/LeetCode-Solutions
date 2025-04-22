class Solution {
    public int maxScore(int[] cardPoints, int k) {
        ArrayList<Integer> nums=new ArrayList<>();
        for(int num : cardPoints){
            nums.add(num);
        }

        ArrayList<Integer> result=new ArrayList<>(nums);
        result.addAll(nums);

        int[] finalarr=new int[result.size()];
        for(int i=0;i<result.size();i++){
            finalarr[i]=result.get(i);
        }

        int n=finalarr.length;
        int n1=cardPoints.length;
        int l=n1-k;
        int temp=0;
        int ans=0;
        for(int r=n1-k;r<n1+k;r++){
            temp+=finalarr[r];
            while(r-l+1 > k){
                temp-=finalarr[l];
                l++;
            }
            if(r-l+1 == k){
                ans=Math.max(ans,temp);
            }
        }
        return ans;
    }
}
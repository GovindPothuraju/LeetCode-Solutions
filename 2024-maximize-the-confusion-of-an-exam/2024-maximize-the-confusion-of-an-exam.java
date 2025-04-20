class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n=answerKey.length();
        int ans=0;
        int temp1=0;
        int temp2=0;
        int l=0;
        for(int r=0;r<n;r++){
            if(answerKey.charAt(r) == 'T'){
                temp1++;
            }else{
                temp2++;
            }
            while(Math.min(temp1,temp2) > k){
                if(answerKey.charAt(l) == 'T'){
                    temp1--;
                }else{
                    temp2--;
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
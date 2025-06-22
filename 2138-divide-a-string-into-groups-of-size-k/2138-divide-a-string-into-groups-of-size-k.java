class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        StringBuilder str=new StringBuilder(s);

        int res=n%k;
        if(res!=0){
            int temp=k-res;
            for(int i=0;i<temp;i++){
                str.append(fill);
            }
        }

        int g=str.length()/k;
        String[] ans=new String[g];
        for(int i=0;i<str.length();i+=k){
            ans[i/k]=str.substring(i,i+k);
        }
        return ans;
    }
}
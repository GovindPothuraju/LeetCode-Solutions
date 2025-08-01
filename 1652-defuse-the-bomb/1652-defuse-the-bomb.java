class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int val=code[i];
            int sum=0;
            if(k==0){
                res[i]=0;
            }else if(k>0){
                for(int j=0;j<k;j++){
                    sum+=code[(i+j+1)%n];
                }
                res[i]=sum;
            }else if(k<0){
                for(int j=1;j<=-k;j++){
                    sum+=code[(n+i-j)%n];
                }
                res[i]=sum;
            }
        }
        return res;
    }
}
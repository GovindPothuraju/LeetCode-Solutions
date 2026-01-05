class Solution {
    public int strStr(String haystack, String needle) {
        int m=needle.length();
        // find LPS array
        int[] lps=new int[m];
        lps[0]=0;
        int i=0;
        int j=1;
        while(j<m){
            if(needle.charAt(i)== needle.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;
            }else{
                if(i==0){
                    lps[j]=0;
                    j++;
                }else{
                    i=lps[i-1];
                }
            }
        }
        i=0;
        j=0;
        int n=haystack.length();
        while(i<n){
            if(haystack.charAt(i)== needle.charAt(j)){
                i++;
                j++;
                if(j==m){
                    return i-j;
                }
            }else{
                if(j==0){
                    i++;
                }else{
                    j=lps[j-1];
                }
            }
        }
        
        return -1;
    }
}
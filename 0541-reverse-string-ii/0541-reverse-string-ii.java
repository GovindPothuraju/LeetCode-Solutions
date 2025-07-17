class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb=new StringBuilder(s);
        int n=sb.length();
        if(n<k) return s;
        int i=0;
        while(i<n){
            int l=i;
            int r=Math.min(i+k-1,n-1);
            while(l<r){
                char temp=sb.charAt(l);
                sb.setCharAt(l,sb.charAt(r));
                sb.setCharAt(r,temp);
                l++;
                r--;
            }
            i+=2*k;
        }     
        return sb.toString();
    }
}
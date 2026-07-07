class Solution {
    public long sumAndMultiply(int n) {
        if(n==0)return 0;
        StringBuilder sb = new StringBuilder(Integer.toString(n));
        int temp = sb.length();
        int i=0;
        while(i<sb.length()){
            char ch = sb.charAt(i);
            if(ch=='0'){
                sb.deleteCharAt(i);
            }else{
                i++;
            }
        }
        long x = Long.parseLong(sb.toString());
        long sum = 0;
        for(i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            sum+= (ch-'0');
        }
        return x*sum;
    }
}
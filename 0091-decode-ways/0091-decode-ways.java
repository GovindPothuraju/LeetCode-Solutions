/*class Solution {
    int res = 0;
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        if(n==1) return 1;
        backtrack(0,s,n);
        return res;
    }
    private void backtrack(int st,String s , int n){
        if(st == n){
            res++;
            return;
        }
        if(s.charAt(st) == '0'){
            return;
        }
        if(st<n){
            backtrack(st+1,s,n);
        }
            
        if(st+1 < n){
            char ch1 = s.charAt(st);
            char ch2 = s.charAt(st+1);
            int len = (ch1-'0')*10 + (ch2-'0');
            if(len>=10 && len <= 26){
                backtrack(st+2,s,n);
            }
        }
    }
}*/

// using memoization 
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        if(n==1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return backtrack(0,s,dp);
    }
    private int backtrack(int st,String s,int[] dp){
        // base case
        if (st == s.length()) {
            return 1;
        }
        // edge case
        if(s.charAt(st) == '0'){
            return 0;
        }
        if(dp[st]!= -1) return dp[st];
        // if single character is valid
        int ways = backtrack(st+1,s,dp);   
        // add two character 
        if(st+1 < s.length()){
            char ch1 = s.charAt(st);
            char ch2 = s.charAt(st+1);
            int len = (ch1-'0')*10 + (ch2-'0');
            if(len>=10 && len <= 26){
                ways+=backtrack(st+2,s,dp);
            }
        }
        dp[st] = ways;
        return dp[st];
    }
}
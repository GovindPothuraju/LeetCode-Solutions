class Solution {
    // 1 top down
    // HashMap<Integer, Integer> hm = new HashMap<>();
    // public int fib(int n) {
    //     if(n<2){
    //         return n;
    //     }
    //     if(hm.containsKey(n)){
    //         return hm.get(n);
    //     }
    //     int result= fib(n-1)+fib(n-2);
    //     hm.put(n,result);
    //     return result;
    // }
    

    // 2 bottom up (Tabulation)
    public int fib(int n) {
        if(n<2) return n;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
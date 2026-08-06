class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            boolean temp = isDivisible(i,t);
            if(temp)return i; 
        }
        return -1;
    }
    private boolean isDivisible(int n,int k){
        int product = 1;
        while(n>0){
            int digit = n%10;
            product*=digit;
            n/=10;
        }
        return product%k == 0;
    }
}
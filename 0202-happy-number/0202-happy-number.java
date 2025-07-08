class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs=new HashSet<>();
        while(n!=1 && !hs.contains(n)){
            hs.add(n);
            n=square(n);
        }
        return n==1;
    }
    public int square(int n){
        int sum=0;
        while(n>0){
            int x=n%10;
            sum+=x*x;
            n/=10;
        }
        return sum;
    }
}
class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0;
        long pro = 1;
        int temp = n;
        while(n>0){
            int digit = n%10;
            sum+=digit;
            pro*=digit;
            n/=10;
        }
        System.out.println(temp+" "+(sum+pro));
        return temp%(sum+pro) == 0;
    }
}
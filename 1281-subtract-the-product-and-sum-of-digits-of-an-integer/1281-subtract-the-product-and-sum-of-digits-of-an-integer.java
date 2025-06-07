class Solution {
    public int subtractProductAndSum(int n) {
        int p=1;
        int s=0;
        while(n!=0){
            int digi=n%10;
            p*=digi;
            s+=digi;
            n/=10;
        }
        return p-s;
    }
}
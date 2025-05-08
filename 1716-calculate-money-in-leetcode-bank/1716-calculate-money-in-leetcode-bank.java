class Solution {
    public int totalMoney(int n) {
        int res=0;
        int temp=n/7;
        int k=4;
        for(int i=0;i<temp;i++){
            res+=k*7;
            k++;
        }
        int temp1=n%7;
        temp++;
        for(int i=0;i<temp1;i++){
            res+=temp;
            temp++;
        }
        return res;
    }
}
class Solution {
    public boolean isHappy(int n) {
        if(1+(n-1)%9 == 1){
            return true;
        }else{
            return false;
        }
    }
}
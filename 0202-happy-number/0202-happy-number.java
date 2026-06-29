class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(n!=1){
            hs.add(n);
            int square = getSquare(n);
            if(hs.contains(square)){
                return false;
            }
            n = square;
        }
        return true;
    }
    private int getSquare(int num){
        int sum = 0;
        while(num>0){
            int digit = num%10;
            sum = sum + digit*digit;
            num/=10;
        }
        return sum;
    }
}
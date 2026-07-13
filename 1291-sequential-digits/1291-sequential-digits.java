class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> sequentialDigits(int low, int high) {
        for (int i = 1; i <= 9; i++) {
            backtrack(low, high, 0, i);
        }
        Collections.sort(res);
        return res;
    }

    private void backtrack(int low, int high, int num, int digit) {
        // base case
        if (low <= num && num <= high) {
            res.add(num);
        }
        if (num > high) {
            return;
        }
        if(digit == 9){
            int temp = num*10+digit;
            if( low <= temp && temp <= high){
                res.add(temp);
            }
            return;
        }
        // apply recusion from num+1
        backtrack(low, high, num * 10 + digit, digit + 1);
    }
}
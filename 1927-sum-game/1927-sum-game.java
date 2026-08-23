class Solution {

    public boolean sumGame(String num) {

        double leftHalf = 0;
        double rightHalf = 0;

        int n = num.length();

        for (int i = 0; i < n / 2; i++) {

            if (num.charAt(i) == '?') {
                leftHalf += 4.5;
            } else {
                leftHalf += num.charAt(i) - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {

            if (num.charAt(i) == '?') {
                rightHalf += 4.5;
            } else {
                rightHalf += num.charAt(i) - '0';
            }
        }

        return leftHalf != rightHalf;
    }
}
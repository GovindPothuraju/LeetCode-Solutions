/*class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n = str2.length();
        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
            String sub = str2.substring(0, i + 1);
            if (isDivisible(str1, sub) && isDivisible(str2, sub)) {
                if (sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }
        return ans;
    }

    private boolean isDivisible(String str, String sub) {
        int len = sub.length();
        if (str.length() % len != 0) return false;

        StringBuilder sb = new StringBuilder();
        int times = str.length() / len;
        for (int i = 0; i < times; i++) {
            sb.append(sub);
        }
        return sb.toString().equals(str);
    }
}
*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}

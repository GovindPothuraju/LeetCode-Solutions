class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            String str=words[i];
            StringBuilder sb = new StringBuilder(str);
            String reversedStr = sb.reverse().toString();
            if(str.equals(reversedStr)){
                return str;
            }
        }
        return "";
    }
}
class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        String res="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')') {
                count--;
            }
            if(count != 0){
                 res+=s.charAt(i);
            }
            if(s.charAt(i)=='(') {
                count++;
            }
        }
        return res;
    }
}
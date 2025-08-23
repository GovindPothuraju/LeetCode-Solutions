class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:st){
            sb.append(c);
        }
        while(sb.length()>0 && sb.charAt(0)=='0' ){
            sb.deleteCharAt(0);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
class Solution {
    public String processStr(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                st.push(ch);
            }else if(ch=='*'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else if(ch=='#'){
                duplicateCurrent(st);
            }else if(ch=='%'){
                reverseCurrent(st);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
    private void duplicateCurrent(Stack<Character> st){
        StringBuilder s = new StringBuilder();
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        int l=s.length();
        for(int j=l-1;j>=0;j--){
            st.push(s.charAt(j));
        }
        for(int j=l-1;j>=0;j--){
            st.push(s.charAt(j));
        }
    }
    private void reverseCurrent(Stack<Character> st){
        StringBuilder s = new StringBuilder();
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        int l=s.length();
        for(int j=0;j<l;j++){
            st.push(s.charAt(j));
        }
    }
}
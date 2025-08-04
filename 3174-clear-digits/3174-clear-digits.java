class Solution {
    public String clearDigits(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>47 && s.charAt(i)<58){
                st.pop();
                continue;
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.peek());
            st.pop();
        }
        return res.reverse().toString();
    }
}
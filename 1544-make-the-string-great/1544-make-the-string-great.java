class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=!st.isEmpty()?st.peek():0;
            if(Math.abs(a-b)==32){
                st.pop();
            }else{
                st.push(a);
            }
        }
        System.out.println(st);
        StringBuilder sb=new StringBuilder();
        for(char c:st){
            sb.append(c);
        }
        return sb.toString();
        /*String res="";
        for(char c:st){
            res+=c;
        }
        return res;*/
    }
}
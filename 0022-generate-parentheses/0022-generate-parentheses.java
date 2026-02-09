class Solution {
    List<String> res=new ArrayList<>();
    String s="()";
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(),n,0,0);
        return res;
    }
    private void backtrack(StringBuilder sb,int n,int open,int close){
        System.out.println(sb.toString());
        if(open==close && sb.length()==2*n) {
            res.add(sb.toString());
            return;
        }
        if(open>n)return;
        if(close>open)return;
        for(int i=0;i<2;i++){
            char ch=s.charAt(i);
            sb.append(ch);
            if(ch=='('){
                open++;
            }
            else{
                close++;
            }
            backtrack(sb,n,open,close);
            sb.deleteCharAt(sb.length()-1);
            if(ch=='(')open--;
            if(ch==')')close--;
        }
    }
}
class Solution {
    // String str="(*)";
    // boolean res=false;
    // public boolean checkValidString(String s) {
    //     if(s.length()<=1)return res;
    //     backtrack(new StringBuilder(),0,s);
    //     return res;
    // }
    // private void backtrack(StringBuilder sb,int start,String s){
    //     if(res)return;
    //     if(sb.length() == s.length()){
    //         if(sb.toString().equals(s)){
    //             res=true;
    //         }
    //         return;
    //     }
    //     for(int i=0;i<=2;i++){
    //         sb.append(str.charAt(i));
    //         backtrack(sb,i+1,s);
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    // }
     public boolean checkValidString(String s) {
        int min=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                min++;
                max++;
            }else if(ch==')'){
                min--;
                max--;
            }else if(ch=='*'){
                min--;
                max++;
            }
            if(min<0)min=0;
            if(max<0)return false;
        }
        return min==0;
     }
}
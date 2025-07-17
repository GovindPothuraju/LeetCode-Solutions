class Solution {
    /* using extra space
    
    public boolean isPalindrome(String s) {
        String res="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9'){
                res+=Character.toLowerCase(ch);
            }
        }
        String rev=reverse(res);
        return res.equals(rev);
    }
    public String reverse(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }*/

    public boolean isPalindrome(String s) {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                res.append(Character.toLowerCase(ch));
            }
        }
        int l=0;
        int r=res.length()-1;
        while(l<r){
            if(res.charAt(l) != res.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
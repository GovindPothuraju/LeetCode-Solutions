class Solution {
    public boolean isSubsequence(String s, String t) {
        StringBuffer sb=new StringBuffer(t);
        int i=0;
        for(int j=0;j<sb.length();){
            char ch=sb.charAt(j);
            if(i<s.length() && ch==s.charAt(i)){
                i++;
                j++;
            }else{
                sb.deleteCharAt(j);
            }
        }
        return s.equals(sb.toString());
    }
}
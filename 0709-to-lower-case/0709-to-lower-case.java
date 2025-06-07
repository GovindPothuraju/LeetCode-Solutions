class Solution {
    public String toLowerCase(String s) {
        StringBuffer sb=new StringBuffer(s);
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(Character.isUpperCase(ch)){
                 sb.setCharAt(i, Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
}
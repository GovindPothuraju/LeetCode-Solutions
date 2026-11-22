class Solution {
    public boolean checkString(String s) {
        boolean start = false;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'b'){
                start = true;
            }
            if(start && ch=='a'){
                return false;
            }
        }
        return true;
    }
}
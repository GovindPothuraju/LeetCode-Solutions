class Solution {
    public int myAtoi(String s) {
        int i=0,n=s.length();
        boolean negative=false;

        while(i<n && s.charAt(i)==' ') i++;
        
        if(i<n && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            negative= s.charAt(i)=='-';
            i++;
        }
        int res=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';

            if(res > (Integer.MAX_VALUE-digit)/10 ){
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res=res*10+digit;
            i++;
        }
        return negative? -res : res;
    }
}
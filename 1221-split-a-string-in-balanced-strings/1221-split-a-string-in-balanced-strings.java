class Solution {
    public int balancedStringSplit(String s) {
        int count1=0;
        int count2=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch == 'R') count1++;
            if(ch == 'L') count2++;
            if(count1==count2){
                res++;
                count1=0;
                count2=0;
            }
        }
        return res;
    }
}
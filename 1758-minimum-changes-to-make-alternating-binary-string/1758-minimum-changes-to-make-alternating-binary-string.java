class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int st1=0;
        int st2=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(i%2 == 0){
                if(ch!='0')st1++;
                if(ch!='1')st2++;
            }else{
                if(ch!='1')st1++;
                if(ch!='0')st2++;
            }
        }
        return Math.min(st1,st2);
    }
}
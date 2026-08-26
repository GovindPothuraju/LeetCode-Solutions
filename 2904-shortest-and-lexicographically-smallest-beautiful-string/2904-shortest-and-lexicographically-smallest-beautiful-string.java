class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int ones = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='1')ones++;
        }
        if(ones<k)return "";
        String res = "";
        int l=0;
        int count = 0;
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            if(ch=='1')count++;
            while(count>=k){
                String temp = s.substring(l,r+1);;
                if(res=="" || res.length()> temp.length()){
                    res = temp;
                } 
                else if(res.length() == temp.length()){
                    res = (res.compareTo(temp) < 0? res : temp);
                }

                if(s.charAt(l)=='1')count--;
                l++;
            }
        }
        return res;
    }
}
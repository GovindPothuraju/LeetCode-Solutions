class Solution {
    public char processStr(String s, long k) {
        long l = 0L;
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='*'){
                if(l > 0){
                    l--;
                }
            }else if(ch=='#')l*=2;
            else if(ch=='%')continue;
            else{l++;}
        }
        if (k >= l) return '.';

        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch=='*')l++;
            else if(ch=='#'){
                l = l/2;
                if(k>=l) k-=l;
            }else if(ch=='%'){
                k=l-k-1;
            }else{
                l--;
                if(l==k)return s.charAt(i);
            }   
        }
        return '.';
    }
}
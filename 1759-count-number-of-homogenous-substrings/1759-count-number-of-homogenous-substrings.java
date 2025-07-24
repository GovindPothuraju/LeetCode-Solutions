class Solution {
    /* using hashmap
     public int countHomogenous(String s) {
        long mod=1000000007L;
        long ans=0;
        int l=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            if(hm.size()>1){
                while(s.charAt(l)!=ch){
                    if(hm.containsKey(s.charAt(l))){
                        hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                        if(hm.get(s.charAt(l))==0){
                            hm.remove(s.charAt(l));
                        }
                    }
                    l++;
                }
            }
            ans+=r-l+1;
            System.out.println(s.substring(l,r+1)+" "+ans);  
        }
        return (int)(ans%mod);
    }*/
     public int countHomogenous(String s) {
        int MOD = 1_000_000_007;
        int l=0;
        int res=0;
        for(int r=0;r<s.length();r++){
            if(s.charAt(l)==s.charAt(r)){
                res=(res+r-l+1) % MOD;
            }
            else{
                l=r;
                res=(res+1%MOD);//for starting character
            }
        }
        return (int)res;
     }
}
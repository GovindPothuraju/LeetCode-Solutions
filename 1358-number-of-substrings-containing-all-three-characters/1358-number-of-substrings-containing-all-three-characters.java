class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        int l=0;
        int res=0;
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            if(hm.size() == 3){
                res += (n-r);
            }

            while(hm.size() ==3){
                hm.put(s.charAt(l) , hm.get(s.charAt(l))-1);
                if(hm.get(s.charAt(l)) == 0){
                    hm.remove(s.charAt(l));
                }
                if(hm.size()==3){
                   // res++;
                    res+= (n-r);
                } 
                l++;
            }
        }
        return res;
    }
}
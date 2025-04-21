class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int n=s.length();
        int l=0;
        int ans=0;
        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.size() == 3){
                ans+=n-r;
                char temp=s.charAt(l);
                hm.put(temp,hm.get(temp)-1);
                if(hm.get(temp) == 0){
                    hm.remove(temp);
                }
                l++;
            }
        }
        return ans;
    }
}
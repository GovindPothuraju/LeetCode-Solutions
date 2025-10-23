class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int n=s.length();
        int ans=0;
        int maxFreq=0;
        int l=0;
        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,hm.get(ch));

            if(r-l+1-maxFreq > k){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
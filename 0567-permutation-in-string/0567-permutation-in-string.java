class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n1=s1.length();
        int n2=s2.length();
        if(n1 > n2) return false;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n1;i++){
            char key = s1.charAt(i);
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        for(int i=0;i<=n2-n1;i++){
            String s = s2.substring(i,i+n1);
            if(isEqual(s,hm)){
                return true;
            }
        }
        return false;

    }
    private boolean isEqual(String s , HashMap<Character,Integer> hm){
        HashMap<Character,Integer> hm1 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char key = s.charAt(i);
            hm1.put(key,hm1.getOrDefault(key,0)+1);
        }
        if(hm1.size() != hm.size()) return false;
        for(char ch : hm.keySet()){
            if(!hm1.containsKey(ch)){
                return false;
            }else if(hm1.containsKey(ch) && !hm1.get(ch).equals(hm.get(ch))){
                return false;
            }
        }
        return true;
    }
}
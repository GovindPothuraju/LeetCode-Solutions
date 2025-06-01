class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int n1=s.length();
        int n2=t.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n1;i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n2;i++){
            char ch=t.charAt(i);
            if(!hm.containsKey(ch)){
                return false;
            }
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch) == 0){
                    hm.remove(ch);
                }
            
        }
        if(hm.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
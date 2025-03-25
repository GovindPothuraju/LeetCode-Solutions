class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm1=new HashMap<>();
        HashMap<Character,Character> hm2=new HashMap<>();
        Boolean ans=true;
        for(int i=0;i<s.length();i++){
                char sch=s.charAt(i);
                char tch=t.charAt(i);
                if(!hm1.containsKey(sch) && !hm2.containsKey(tch)){
                    hm1.put(sch,tch);
                    hm2.put(tch,sch);
                }else if((hm1.containsKey(sch) && hm1.get(sch)!=tch) || (hm2.containsKey(tch) && hm2.get(tch)!=sch)){
                    ans=false;
                    break;
                }
            } 
            return ans;      
    }
}
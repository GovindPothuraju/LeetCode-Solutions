class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        List<Integer> res=new ArrayList<>();
        int n=s.length();
        HashMap<Character,Integer> thm=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            thm.put(ch,thm.getOrDefault(ch,0)+1);

            if(isEqual(thm,hm)){
                res.add(count(thm));
                thm=new HashMap<>();
            }
        }
        return res;
    }
    private static int count(HashMap<Character,Integer> hm){
        int res=0;
        for(char key:hm.keySet()){
            res+=hm.get(key);
        }
        return res;
    }

    private static boolean isEqual(HashMap<Character,Integer> hm1,HashMap<Character,Integer> hm2){
        if(hm1.size()==0)return false;
        for(char key:hm1.keySet()){
            if(hm1.get(key) != hm2.get(key)){
                return false;
            }
        }
        return true;
    }
}
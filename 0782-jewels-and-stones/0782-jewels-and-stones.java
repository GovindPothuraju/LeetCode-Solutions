class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int res=0;
       HashMap <Character,Integer> machas=new HashMap<>();
       for(int i=0;i<stones.length();i++){
            char key=stones.charAt(i);
            machas.put(key,machas.getOrDefault(key,0)+1);
       } 
       
       for(int i=0;i<jewels.length();i++){
         if(machas.containsKey(jewels.charAt(i))){
            res+=machas.get(jewels.charAt(i));
         }
       }
       return res;
    }
}
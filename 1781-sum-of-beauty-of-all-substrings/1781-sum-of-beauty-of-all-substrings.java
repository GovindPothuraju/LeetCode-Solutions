class Solution {
    /*public int beautySum(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> hm=new HashMap<>();
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int freq : hm.values()) {
                    max = Math.max(max, freq);
                    min = Math.min(min, freq);
                }
                res += (max - min);
            }
        }
        return res;
    }*/

    public int beautySum(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            int[] count=new int[26];
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                count[ch-'a']++;
                int min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    min=Math.min(min,count[k]);
                }
                
                
                res += (max - min);
            }
        }
        return res;
    }
}
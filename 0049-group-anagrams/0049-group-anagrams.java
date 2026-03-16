class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        HashMap<String,ArrayList<String>> hm=new HashMap<>();

        //String[] temp=new String[n];
        for(int i=0;i<n;i++){
            /* this takes o(m log m) time can we reduce it by generating a hash key
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            temp[i]= new String(charArray);*/
            int[] freq=new int[26];
            for(int j=0;j<strs[i].length();j++){
                freq[strs[i].charAt(j)-'a']++;
            }

            String key="";
            for(int j=0;j<26;j++){
                key+="#"+freq[j];
            }
            if(!hm.containsKey(key)){
                hm.put(key,new ArrayList<>());
            }
            hm.get(key).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
    }
}
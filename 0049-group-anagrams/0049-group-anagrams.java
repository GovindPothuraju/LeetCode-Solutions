class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;

        String[] temp=new String[n];
        for(int i=0;i<n;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            temp[i]= new String(charArray);
        }

        HashMap<String,ArrayList<String>> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!hm.containsKey(temp[i])){
                hm.put(temp[i],new ArrayList<>());
            }
            hm.get(temp[i]).add(strs[i]);
        }

        List<List<String>> res=new ArrayList<>();
        for(String key:hm.keySet()){
            res.add(hm.get(key));
        }
        return res;
    }
}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            int key=nums1[i];
            hm.put(key,hm.getOrDefault(key,0));
        }
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            int key=nums2[i];
            if(hm.containsKey(key)){
                hs.add(key);
            }
        }
        int[] res=new int[hs.size()];
        int i=0;
        for(int num:hs){
            res[i++]=num;
        }
        return res;
    }
}
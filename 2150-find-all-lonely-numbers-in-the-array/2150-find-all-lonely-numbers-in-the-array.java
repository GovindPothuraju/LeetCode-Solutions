class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int key=nums[i];
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int val=nums[i];
            if(!hm.containsKey(val+1)&& !hm.containsKey(val-1) && hm.get(val)==1){
                list.add(val);
            }
        }
        return list;
    }
}
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        int ele=(int)Math.floor(n/3);
        for(int i=0;i<n;i++){
            int key=nums[i];
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:hm.keySet()){
            if(hm.get(num)>ele){
                arr.add(num);
            }
        }
        return arr;
    }
}
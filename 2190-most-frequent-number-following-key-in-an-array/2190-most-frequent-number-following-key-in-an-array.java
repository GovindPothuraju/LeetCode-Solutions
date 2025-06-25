class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        int temp=0;
        int res=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]==key){
                int k=nums[i+1];
                hm.put(k,hm.getOrDefault(k,0)+1);
                if(hm.get(k)>temp){
                    temp= hm.get(k);
                    res=k;
                }
            }
        }
        return res;
    }
}
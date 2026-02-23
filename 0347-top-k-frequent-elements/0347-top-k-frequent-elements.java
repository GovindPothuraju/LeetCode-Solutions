class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int key:hm.keySet()){
            pq.add(new int[]{key,hm.get(key)});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res=new int[pq.size()];
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll()[0];
        }
        return res;
    }
}
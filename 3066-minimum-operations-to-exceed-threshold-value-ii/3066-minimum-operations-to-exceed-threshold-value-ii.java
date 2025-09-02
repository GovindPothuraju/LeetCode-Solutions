class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<k){
                q.offer(nums[i]);
            }
        }

        int count=0;
        while(!q.isEmpty() ){
            long ele1=q.poll();
            count++;
            if(q.isEmpty()) break;
            long ele2=q.poll();
            long temp=Math.min(ele1,ele2)*2+Math.max(ele1,ele2);
            
            if(temp<k) q.offer((int)temp);
        }
        return count;
    }
}
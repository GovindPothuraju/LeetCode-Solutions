class Solution {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            Collections.reverseOrder()
        );
        for(int num:cost){
            pq.add(num);
        }
        int res=0;
        while(!pq.isEmpty()){
            int num1=0;
            int num2=0;
            if(!pq.isEmpty())num1=pq.poll();
            if(!pq.isEmpty())num2=pq.poll();
            res+=num1+num2;
            pq.poll();
        }
        return res;
    }
}
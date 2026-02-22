class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:arr){
            pq.add(num);
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i=1;
        while(pq.size()>0){
            if(!hm.containsKey(pq.peek())){
                hm.put(pq.poll(),i++);
            }else{
                pq.poll();
            }
            
        }
        for(i=0;i<arr.length;i++){
            arr[i]=hm.get(arr[i]);
        }
        return arr;
    }
}
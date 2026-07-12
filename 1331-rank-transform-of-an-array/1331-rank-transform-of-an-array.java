/*class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int num:arr){
        //     pq.add(num);
        // }
        // HashMap<Integer,Integer> hm=new HashMap<>();
        // int i=1;
        // while(pq.size()>0){
        //     if(!hm.containsKey(pq.peek())){
        //         hm.put(pq.poll(),i++);
        //     }else{
        //         pq.poll();
        //     }
            
        // }
        // for(i=0;i<arr.length;i++){
        //     arr[i]=hm.get(arr[i]);
        // }
        // return arr;
        // int[] sorted = arr.clone();
        // Arrays.sort(sorted);

        // HashMap<Integer, Integer> map = new HashMap<>();
        // int rank = 1;

        // for (int num : sorted) {
        //     if (!map.containsKey(num)) {
        //         map.put(num, rank++);
        //     }
        // }

        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = map.get(arr[i]);
        // }

        // return arr;
    }
}*/




class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:arr){
            pq.add(num);
        }
        int n = 1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(!pq.isEmpty()){
            int val = pq.poll();
            if(!hm.containsKey(val)){
                hm.put(val,n++);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = hm.get(arr[i]);
        }
        return arr;
    }
}
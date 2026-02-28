class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<words.length;i++){
            String temp=words[i];
            hm.put(temp,hm.getOrDefault(temp,0)+1);
        }

        PriorityQueue<String> pq=new PriorityQueue<>((a, b) -> {
                if (!hm.get(a).equals(hm.get(b))) {
                    return hm.get(a) - hm.get(b);   // smaller freq first
                }
                return b.compareTo(a);              // reverse lexicographical
            });
        for(String s:hm.keySet()){
            pq.add(s);
            if(pq.size()>k){
                pq.poll();
            }
        }
        ArrayList<String> res=new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
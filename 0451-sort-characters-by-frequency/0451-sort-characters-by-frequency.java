class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        for(char ch:hm.keySet()){
            pq.add(ch);
        }

        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            for(int i=0;i<hm.get(ch);i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
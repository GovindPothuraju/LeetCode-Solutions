class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> hm = new HashMap<>();

        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        } 
        int req = hm.size()/8;
        if(hm.size()%8 != 0){
            req++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char key : hm.keySet()){
            pq.add(hm.get(key));
        }
        int count = 1;
        int res = 0;
        while(!pq.isEmpty()){
            int val = pq.poll();
            if(count>=1 && count<=8){
                res+=(val);
            }else if(count>8 && count<=16){
                res+=(val*2);
            }else if(count>16 && count<=24){
                res+=(val*3);
            }else{
                res+=(val*4);
            }
            count++;
        }
        return res;
    }
}
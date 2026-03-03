class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freq){
            if(f>0)pq.add(f);
        }

        int time=0;
        while(!pq.isEmpty()){
            ArrayList<Integer> temp=new ArrayList<>();
            int tasksdone=0;
            int cycle=n+1;
            while(cycle>0 && !pq.isEmpty()){
                int curr=pq.poll();
                tasksdone++;
                if(curr-1>0){
                    temp.add(curr-1);
                }
                cycle--;
            }
            for(int num:temp){
                pq.add(num);
            }
            if(pq.isEmpty()){
                time+=tasksdone;
            }
            else{
                time+=(n+1);
            }
        }
        return time;
    }
}
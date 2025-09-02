class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.offer(new int[]{i,tickets[i]});
        }
        int time=0;
        while(!q.isEmpty()){
            time++;
            int[] person=q.poll();
            int ele=person[1];
            int idx=person[0];

            ele--;
            if(idx==k && ele==0){
                return time;
            }

            if(ele>0){
                q.offer(new int[]{idx,ele});
            }
        }
        return time;
    }
}
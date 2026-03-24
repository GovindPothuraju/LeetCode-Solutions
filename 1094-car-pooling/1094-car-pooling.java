class Solution {
    // 1) using line sweep algorithm
   /*public boolean carPooling(int[][] trips, int capacity){
        ArrayList<int[]> events=new ArrayList<>();

        for(int i=0;i<trips.length;i++){
            events.add(new int[]{trips[i][1],1,trips[i][0]});
            events.add(new int[]{trips[i][2],-1,-trips[i][0]});
        }

        Collections.sort(events,(a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return a[0]-b[0];
        });

        int sum=0;
        for(int[] e:events){
            sum+=e[2];
            if(sum>capacity)return false;
            System.out.println(Arrays.toString(e));
        }

        return true;
    }*/


    // 2)using difference array
    public boolean carPooling(int[][] trips, int capacity){

        int max=0;
        for(int i=0;i<trips.length;i++){
            max=Math.max(max,trips[i][1]);
            max=Math.max(max,trips[i][2]);
        }

        int[] diff=new int[max+1];
        for(int i=0;i<trips.length;i++){
            int st=trips[i][1];
            int end=trips[i][2];
            int val=trips[i][0];

            diff[st]+=val;
            if(end+1<max)diff[end+1]-=val;
        }

        for(int i=1;i<max;i++){
            diff[i]+=diff[i-1];
        }
        for(int i=0;i<max;i++){
            if(diff[i]>capacity)return false;
        }
        return true;
    }
}
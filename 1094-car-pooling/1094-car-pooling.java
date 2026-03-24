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
        int[] diff=new int[1001];
        for(int i=0;i<trips.length;i++){
            int st=trips[i][1];
            int end=trips[i][2];
            int val=trips[i][0];

            diff[st]+=val;
            diff[end]-=val;
        }
        int curr=0;
        for(int i=0;i<1001;i++){
            curr+=diff[i];
            if(curr > capacity)return false;
        }
        return true;
    }
}
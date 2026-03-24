class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
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
    }
}
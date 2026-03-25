class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff=new int[n+1];
        for(int[] book:bookings){
            int st=book[0];
            int end=book[1];
            int val=book[2];

            diff[st]+=val;
            if(end+1<=n)diff[end+1]-=val;
        }
        System.out.println(Arrays.toString(diff));
        int[] res=new int[n];
        int k=0;
        for(int i=1;i<=n;i++){
            diff[i]+=diff[i-1];
            res[k++]=diff[i];
        }
        System.out.println(Arrays.toString(diff));
        return res;
    }
}
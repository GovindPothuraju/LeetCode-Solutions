class Solution {
    // using difference array technique
    /*public int[] corpFlightBookings(int[][] bookings, int n) {
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
    }*/

    // using line sweep algorithm
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res=new int[n];
        for(int[] book: bookings){
            res[book[0]-1]+=book[2];
            if(book[1] < n){
                res[book[1]]-=book[2];
            }
        }
        for(int i=1;i<n;i++){
            res[i]+=res[i-1];
        }
        return res;
    }
}
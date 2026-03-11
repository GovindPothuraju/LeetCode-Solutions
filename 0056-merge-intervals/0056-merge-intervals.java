class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        int n=arr.length;
        ArrayList<int[]> res=new ArrayList<>();

        int st=arr[0][0];
        int ed=arr[0][1];

        for(int i=1;i<arr.length;i++){
            if(arr[i][0] <= ed){
                st=Math.min(st,arr[i][0]);
                ed=Math.max(ed,arr[i][1]);
            }else{
                res.add(new int[]{st,ed});
                st=arr[i][0];
                ed=arr[i][1];
            }
        }
        res.add(new int[]{st,ed});
        return res.toArray(new int[res.size()][]);
    }
}
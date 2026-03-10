class Solution {
    public int[][] insert(int[][] arr, int[] x) {
        int n=arr.length;
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int i=0;
        //left nonoverlapping intervals
        while(i<n && arr[i][1] < x[0]){
            res.add(new ArrayList<>(Arrays.asList(arr[i][0], arr[i][1])));
            i++;
        }

        //overlapping intevals
        while(i<n && arr[i][0] <= x[1]){
            x[0]=Math.min(arr[i][0],x[0]);
            x[1]=Math.max(arr[i][1],x[1]);
            i++;
        }
        res.add(new ArrayList<>(Arrays.asList(x[0], x[1])));

        //right nonoverlapping intervals
        while(i<n){
            res.add(new ArrayList<>(Arrays.asList(arr[i][0], arr[i][1])));
            i++;
        }
        int[][] ans = new int[res.size()][2];

        for(int j = 0; j < res.size(); j++){
            ans[j][0] = res.get(j).get(0);
            ans[j][1] = res.get(j).get(1);
        }
        return ans;
    }
}
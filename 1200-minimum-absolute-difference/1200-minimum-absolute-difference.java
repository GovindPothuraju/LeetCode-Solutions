class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        List<List<Integer>> res = new ArrayList<>();
        int diff=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            diff=Math.min(diff,arr[i]-arr[i-1]);
        }
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]==diff){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        backtrack(temp,0,nums);
        return res;
    }
    private void backtrack(List<Integer> path, int start,int[] arr){
        res.add(new ArrayList<>(path));
        for(int i=start;i<arr.length;i++){
            path.add(arr[i]);
            backtrack(path,i+1,arr);
            path.remove(path.size()-1);
        }
    }
}
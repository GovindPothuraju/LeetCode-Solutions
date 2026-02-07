class Solution {
    List<List<Integer>> res=new ArrayList<>();
    HashSet<List<Integer>> hs=new HashSet<>();
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        n=nums.length;
        backtrack(new ArrayList<>(),0,nums);
        return res;
    }
    private void backtrack(List<Integer> path,int start,int[] arr){
        if(hs.contains(path)){
            return;
        }else{
            res.add(new ArrayList<>(path));
            hs.add(new ArrayList<>(path));
        }
        for(int i=start;i<n;i++){
            path.add(arr[i]);
            backtrack(path,i+1,arr);
            path.remove(path.size()-1);
        }
    }
}
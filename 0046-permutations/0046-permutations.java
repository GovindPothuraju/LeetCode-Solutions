class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        backtrack(new ArrayList<>(),nums,used);
        return res;
    }
    private void backtrack(List<Integer> path,int[] nums,boolean[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            used[i]=true;
            path.add(nums[i]);
            backtrack(path,nums,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}
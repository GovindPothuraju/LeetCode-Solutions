class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        backtrack(new ArrayList<>(),nums,used);
        return res;
    }
    private void backtrack(List<Integer> path,int[] arr,boolean[] used){
        if(arr.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<arr.length;i++){

            if(used[i])continue;
            if(i>0 && arr[i]==arr[i-1] && !used[i-1])continue;
            
            path.add(arr[i]);
            used[i]=true;
            backtrack(path,arr,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}
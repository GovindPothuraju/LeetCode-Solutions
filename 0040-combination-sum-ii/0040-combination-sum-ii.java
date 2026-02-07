class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(),0,target,candidates);
        return res;
    }
    private void backtrack(List<Integer> path,int start,int target,int[] arr){
        System.out.println(path);
        if(target==0)res.add(new ArrayList<>(path));
        if(target<=0)return;
        for(int i=start;i<arr.length;i++){
            if(i>start && arr[i-1]==arr[i]){
                continue;
            }
            path.add(arr[i]);
            backtrack(path,i+1,target-arr[i],arr);
            path.remove(path.size()-1);
        }
    }
}
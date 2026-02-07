class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(),0,0,candidates,target);
        return res;
    }
    private void backtrack(List<Integer> path,int start,int sum ,int[] arr,int tar){
        if(sum==tar){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(sum+arr[i]>tar ) return;
            path.add(arr[i]);
            sum+=arr[i];
            backtrack(path,i,sum,arr,tar);
            path.remove(path.size()-1);
            sum-=arr[i];
        }
    }
}
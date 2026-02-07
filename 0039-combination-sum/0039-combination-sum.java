class Solution {
    // List<List<Integer>> res=new ArrayList<>();
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     Arrays.sort(candidates);
    //     backtrack(new ArrayList<>(),0,0,candidates,target);
    //     return res;
    // }
    // private void backtrack(List<Integer> path,int start,int sum ,int[] arr,int tar){
    //     if(sum==tar){
    //         res.add(new ArrayList<>(path));
    //         return;
    //     }
    //     for(int i=start;i<arr.length;i++){
    //         if(sum+arr[i]>tar ) return;
    //         path.add(arr[i]);
    //         sum+=arr[i];
    //         backtrack(path,i,sum,arr,tar);
    //         path.remove(path.size()-1);
    //         sum-=arr[i];
    //     }
    // }
    List<List<Integer>> res = new ArrayList<>();
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        n=candidates.length;
        backtrack(new ArrayList<>(), 0, target, candidates);
        return res;
    }

    private void backtrack(List<Integer> path, int start, int target, int[] arr) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <n; i++) {
            if (arr[i] > target) break; // 🔥 correct pruning

            path.add(arr[i]);
            backtrack(path, i, target - arr[i], arr);
            path.remove(path.size() - 1);
        }
    }
}


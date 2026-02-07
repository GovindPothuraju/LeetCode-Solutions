class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int target) {
        backtrack(new ArrayList<>(),1,target,k);
        return res;
    }
    private void backtrack(List<Integer> path,int start,int target,int k){
        if(path.size()==k){
            if( target==0 ){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=start;i<=9;i++){
            if(target-i < 0)break;
            path.add(i);
            backtrack(path,i+1,target-i,k);
            path.remove(path.size()-1);
        }
    }
}
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(new ArrayList<>(),1,n,k);
        return res;
    }
    private void backtrack(List<Integer> path,int start,int n,int k){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        } 
        for(int i=start;i<=n;i++){
            path.add(i);
            backtrack(path,i+1,n,k);
            path.remove(path.size()-1);
        }
    }
}
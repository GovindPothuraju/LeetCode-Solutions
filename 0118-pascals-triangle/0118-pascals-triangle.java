class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                res.get(i).add(1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j!=0 && j!=i){
                    int temp = res.get(i-1).get(j-1) + res.get(i-1).get(j);
                    res.get(i).set(j,temp);
                }
            }
        }
        return res;
    }
}
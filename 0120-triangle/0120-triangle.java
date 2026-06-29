class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1)return triangle.get(0).get(0);
        int max = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=0; j<triangle.get(i).size() ; j++){
                int top = i>0 && triangle.get(i-1).size()-1 >=j ? triangle.get(i-1).get(j) : Integer.MAX_VALUE;
                int topLeft = i>0 && j>0 ? triangle.get(i-1).get(j-1) : Integer.MAX_VALUE;
                int curr = triangle.get(i).get(j) + Math.min(top,topLeft);
                triangle.get(i).set(j , curr);
                // if last row then update max 
                if(i==n-1){
                    max = Math.min(max,triangle.get(i).get(j));
                }
            }
        }
        System.out.println(triangle);
        return max;
    }
}
class Solution {
    public int heightChecker(int[] heights) {
        int[] b=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            b[i]=heights[i];
        }
        Arrays.sort(b);
        int count=0;
        for(int i=0;i<heights.length;i++){
            if(b[i] != heights[i]){
                count+=1;
            }
        }
        return count;
    }
}
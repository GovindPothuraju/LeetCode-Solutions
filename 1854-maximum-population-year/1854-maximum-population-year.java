class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years=new int[2051];
        for(int i=0;i<logs.length;i++){
            int birth=logs[i][0];
            int death=logs[i][1];
            years[birth]++;
            years[death]--;
        }
        int res=0;
        int max=0;
        int curr=0;
        for(int i=1950;i<2051;i++){
            curr+=years[i];
            if(curr > max){
                res=i;
                max=curr;
            }
        }

        return res;
    }
}
class Solution {
    // brute force approach
    /*public int canCompleteCircuit(int[] gas, int[] cost) {
        int index=-1;
        int n=gas.length;
        for(int i=0;i<gas.length;i++){
            if(gas[i]<cost[i]){
                continue;
            }
            boolean isPossible=true;
            int totalGas=0;

            for(int j=0;j<n;j++){
                int idx =(j+i)%n;
                totalGas+=gas[idx];
                totalGas-=cost[idx];

                if(totalGas < 0){
                    isPossible=false;
                    break;
                }
            }
            if(isPossible){
                return i;
            }
                
        }
        return -1;
    }*/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int totalgas=0;
        int totalgain=0;
        
        for(int i=0;i<gas.length;i++){
            int gain=gas[i]-cost[i];

            totalgain+=gain;
            totalgas+=gain;
            if(totalgas < 0){
                totalgas=0;
                start=i+1;
            }
        }
        return totalgain<0 ? -1 : start;
    }

}
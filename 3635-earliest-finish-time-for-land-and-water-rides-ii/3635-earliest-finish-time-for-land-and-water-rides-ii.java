class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int finish1 = Integer.MAX_VALUE;
        int finish2 = Integer.MAX_VALUE;
        int finish3 = Integer.MAX_VALUE;
        int finish4 = Integer.MAX_VALUE;
        // land is first
        // activity-1 i need to find which one is minimum among land+duration
        for(int i=0;i<landStartTime.length ; i++){
            finish1 = Math.min(finish1 ,landStartTime[i]+landDuration[i]);
        }
        // activity-2 i need to find which one is minimum among water+duration
        for(int i=0;i<waterStartTime.length ; i++){
            finish2 = Math.min(finish2 ,Math.max(finish1,waterStartTime[i])+waterDuration[i]);
        }

        // water is first
        // activity-2 i need to find which one is minimum among water+duration
        for(int i=0;i<waterStartTime.length ; i++){
            finish3 = Math.min(finish3 ,waterStartTime[i]+waterDuration[i]);
        }
        // activity-3 i need to find which one is minimum among land+duration
        for(int i=0;i<landStartTime.length ; i++){
            finish4 = Math.min(finish4 ,Math.max(finish3,landStartTime[i])+landDuration[i]);
        }

        return Math.min(finish2,finish4);
    }
}
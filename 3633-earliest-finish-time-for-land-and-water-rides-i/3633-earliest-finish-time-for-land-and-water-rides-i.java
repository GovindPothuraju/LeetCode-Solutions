class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int land=landStartTime[i];
            int landDur=landDuration[i];
            int temp=Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                int water=waterStartTime[j];
                int waterDur=waterDuration[j];

                int landcompleted = land+landDur;

                if(water <= landcompleted ){
                    temp = landcompleted + waterDur;
                }else{
                    temp = water + waterDur;
                }
                min=Math.min(min,temp);
            }
        }
        for(int j=0;j<m;j++){
            int water=waterStartTime[j];
            int waterDur=waterDuration[j];
            int temp=Integer.MAX_VALUE;

            for(int i=0;i<n;i++){
                int land=landStartTime[i];
                int landDur=landDuration[i];
                

                int watercompleted = water+waterDur;

                if(land <= watercompleted ){
                    temp = watercompleted + landDur;
                }else{
                    temp = land + landDur;
                }

                min=Math.min(min,temp);
            }
        }
        return min;
    }
}
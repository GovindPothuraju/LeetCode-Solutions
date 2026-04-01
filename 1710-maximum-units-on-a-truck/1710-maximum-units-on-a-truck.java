class Solution {
    public int maximumUnits(int[][] boxTypes, int capacity) {
        Arrays.sort(boxTypes , (a,b)->b[1]-a[1]);

        int res=0;
        for(int[] b:boxTypes){
            int boxes=b[0];
            int units=b[1];
            if(capacity > 0){
                if(boxes<=capacity){
                    res+=(boxes*units);
                    capacity-=boxes;
                }else{
                    res+=(capacity*units);
                    capacity=0;
                }
            }else{
                break;
            }
        }
        return res;
    }
}
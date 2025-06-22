class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int n=hours.length;
        int count=0;
        for(int i=0;i<n;i++){
            int temp=hours[i];
            if(temp>=target){
                count++;
            }
        }
        return count;
    }
}
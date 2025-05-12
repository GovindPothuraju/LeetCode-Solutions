class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n=arr.length;
        int count=0;
        for(int i=0;i<n-2;i++){
            if(arr[i]%2 != 0) count++;
            if(arr[i+1]%2 != 0) count++;
            if(arr[i+2]%2 != 0) count++;
            if(count == 3){
                return true;
            }
            count=0;
        }
        return false;
    }
}
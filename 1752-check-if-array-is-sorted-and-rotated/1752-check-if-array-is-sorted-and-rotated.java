class Solution {
    public boolean check(int[] arr) {
        int count=0,n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] > arr[(i+1)%n] && ++count>1){
                return false;
            }
        }
        return count<=1;
    }
}
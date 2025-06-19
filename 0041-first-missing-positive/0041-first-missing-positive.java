class Solution {
    public int firstMissingPositive(int[] arr) {
        int n=arr.length;
        int ans=1;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            hs.add(arr[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int num:hs){
            if(num>max){
                max=num;
            }
        }
        for(int i=1;i<=max;i++){
            if(!hs.contains(i)){
                ans=i;
                break;
            }
            if(i==max){
                ans=max+1;
                break;
            }
        }
        return ans;

    }
}
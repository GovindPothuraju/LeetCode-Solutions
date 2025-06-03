class Solution {
    public int maxProfit(int[] arr) {
        /*int profit = 0;
        int mini=arr[0];
        for(int i=1;i < arr.length; i++){
           mini=Math.min(arr[i],mini);
           if(arr[i]-mini>0){
            profit=Math.max(profit,arr[i]-mini);
           }
        }
        return profit;*/
        int n=arr.length;
        int temp=Integer.MIN_VALUE;
        int profit=0;
        int[] right_max=new int[n];
        for(int i=n-1;i>=0;i--){
            temp=Math.max(temp,arr[i]);
            right_max[i]=temp;
        }
        for(int i=0;i<n;i++){
            profit=Math.max(profit,right_max[i]-arr[i]);
        }
        return profit;
    }
}
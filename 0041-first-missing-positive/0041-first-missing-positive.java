class Solution {
    public int firstMissingPositive(int[] arr) {
        /*int n=arr.length;
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
        return ans;*/
        // using cycle sort 
        int n=arr.length;
        int i=0;
        while(i<n){
            int correct=arr[i]-1;
            if(arr[i]>0 && arr[i]<=n && arr[i]!=arr[correct]){
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }else{
                i++;
            }
        }
        for(i=0;i<n;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
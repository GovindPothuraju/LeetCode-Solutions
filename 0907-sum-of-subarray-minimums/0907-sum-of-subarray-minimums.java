class Solution {
    public int sumSubarrayMins(int[] arr) {
        /*long res=0;
        long mod=1_000_000_007L;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int min=arr[i];
                for(int k=i;k<=j;k++){
                    min=Math.min(min,arr[k]);
                }
                res+=min;
            }
        }
        return (int)(res%mod);*/
        int n=arr.length;
        long mod=1_000_000_007L;
        long total=0L;


        
        // function for next smalleer elemets
        int nse[]=new int[n];
        Stack<Integer> st1=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st1.isEmpty() && arr[st1.peek()]>arr[i]){
                st1.pop();
            }
            nse[i]=st1.isEmpty()?n:st1.peek();
            st1.push(i);
        }
        System.out.println(Arrays.toString(nse));



        //function for previous smaller elemets
        int pse[]=new int[n];
        Stack<Integer> st2=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st2.isEmpty() && arr[st2.peek()]>=arr[i]){
                st2.pop();
            }
            pse[i]=st2.isEmpty()?-1:st2.peek();
            st2.push(i);
        }
        System.out.println(Arrays.toString(pse));


        for(int i=0;i<n;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            total+=(long)left*right%mod*arr[i]%mod;
            total%=mod;
        }
        return (int)(total%mod);
    }
}
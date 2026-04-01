class Solution {
    public int minTaps(int n, int[] ranges) {
        // i want to need an array of values which represents how far i can water the garden
        int[] temp = new int[n+1];
        for(int i=0;i<=n;i++){
            int left=Math.max(0,i-ranges[i]);
            int right=Math.min(n,i+ranges[i]);
            // left is my index
            // right is my value
            temp[left]=Math.max(temp[left],right);
        }

        int end=0;
        int fartest=0;
        int taps=0;

        for(int i=0;i<=n;i++){

            if(i>fartest)return -1;

            fartest=Math.max(fartest,temp[i]);
            
            if(i==end){
                taps++;
                end=fartest;
                // if in the middle my n==n then i don't need to check for remaing 
                if(end>=n)return taps;
            }
        }
        return -1;
    }
}
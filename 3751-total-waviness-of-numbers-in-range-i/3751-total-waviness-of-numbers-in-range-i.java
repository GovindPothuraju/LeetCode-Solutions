class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            // calculate the peaks
            int n=i;
            while(n>=100){
                int right = n%10;
                int mid = (n/10)%10;
                int left = (n/100)%10; 
                if(left < mid && mid > right){
                    count++;
                    System.out.println("peaks"+mid+" "+i);
                }
                n/=10;
            }
            // calculate the waves
            n=i;
            while(n>=100){
                int right = n%10;
                int mid = (n/10)%10;
                int left = (n/100)%10; 
                if(left > mid && mid < right){
                    count++;
                    System.out.println("waves"+mid+" "+i);
                }
                n/=10;
            }
        }
        return count;
    }
}
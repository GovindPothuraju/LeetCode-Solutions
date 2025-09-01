class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st=new Stack<>();
        int n=prices.length;
        int res[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && prices[st.peek()]>prices[i]){
                st.pop();
            }
            res[i]=st.isEmpty()?0:prices[st.peek()];
            st.push(i);
        }
        for(int i=0;i<n;i++){
            res[i]=prices[i]-res[i];
        }
        return res;
    }
}
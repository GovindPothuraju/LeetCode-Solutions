class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int nge[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            nge[i]=(st.isEmpty()?0:st.peek()-i);
            st.push(i);
        }
        return nge;
    }
}
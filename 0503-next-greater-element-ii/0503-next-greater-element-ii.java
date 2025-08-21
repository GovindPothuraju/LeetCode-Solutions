class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int res[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i%n]){
                st.pop();
            }
            if(i<n){
                res[i]=st.isEmpty()?-1:arr[st.peek()];
            }
            st.push(i%n);
        }
        return res;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        /*int n=heights.length;
        int[] nse=new int[n];
        int[] pse=new int[n];

        Stack<Integer> st=new Stack<>();
        // next smaller element
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }

        st.clear();
        // previous smaller element
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        System.out.println(Arrays.toString(nse));
        System.out.println(Arrays.toString(pse));

        int ans=0;
        for(int i=0;i<n;i++){
            int width=nse[i]-pse[i]-1;
            int area=heights[i]*width;
            ans=Math.max(ans,area);
        }
        return ans;*/


        // optimal approach in single pass with o(1)Space
        int n=heights.length;
        int max=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                max=Math.max(max,heights[element]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse=n;
            int element=st.pop();
            int pse=st.isEmpty()?-1:st.peek();
            max=Math.max(max,heights[element]*(nse-pse-1));
        }
        return max;
    }
}
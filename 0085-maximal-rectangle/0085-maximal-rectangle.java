class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int psum[][]=new int[n][m];

        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=matrix[i][j]-'0';
                if(matrix[i][j] == '0'){
                    sum=0;
                }
                psum[i][j]=sum;
            }
        }
        // row wise find histogram and max
        for(int i=0;i<n;i++){
            max=Math.max(max,histogram(psum[i]));
        }

        return max;

    }
    public static int histogram(int[] arr){
        int area=0;
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                int ele=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                area=Math.max(area,arr[ele]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ele=st.pop();
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();
            area=Math.max(area,arr[ele]*(nse-pse-1));
        }
        return area;
    }
}
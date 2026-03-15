class Solution {
    //two pass solution 
    /*public int candy(int[] ratings) {
        int n=ratings.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;
        for(int i=1;i<n;i++){
            if(ratings[i-1] < ratings[i]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }

        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1] ){
                right[i]=right[i+1]+1;
            }else{
                right[i]=1;
            }
        }

        int res=0;
        for(int i=0;i<n;i++){
            res+=Math.max(left[i],right[i]);
        }
        return res;
    }*/

    //one pass solution
    public int candy(int[] arr) {
        int n=arr.length;
        int ans=n;
        int i=1;
        while(i<n){
            if(i<n && arr[i-1]==arr[i]){
                i++;
                continue;
            }

            int up=0;
            while(i<n && arr[i-1]<arr[i]){
                up++;
                ans+=up;
                i++;
            }

            int down=0;
            while(i<n && arr[i]<arr[i-1]){
                down++;
                ans+=down;
                i++;
            }

            // handling peek values
            ans-=Math.min(up,down);
        }
        return ans;
    }
}
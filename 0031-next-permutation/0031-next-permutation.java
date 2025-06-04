class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        //2 swap the elements
        if(i>=0){
            int j=n-1;
            while(nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        // 3 reverse after the i
        reverse(nums,i+1,n-1);
    }
        private static void swap(int[] nums,int a,int b){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
        }

        private static void reverse(int[] nums,int s, int e){
            while(s<e){
                swap(nums,s++,e--);
            }
        }

    
}
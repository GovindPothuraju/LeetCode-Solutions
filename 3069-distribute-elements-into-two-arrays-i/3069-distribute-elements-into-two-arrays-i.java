class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i==0)arr1.add(nums[i]);
            if(i==1)arr2.add(nums[i]);
            if(i>1){
                 if(arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1) ){
                    arr1.add(nums[i]);
                }else{
                    arr2.add(nums[i]);
                }
            }          
        }
        int[] res = new int[n];
        int k=0;
        for(int num:arr1){
            res[k++]=num;
        }
        for(int num:arr2){
            res[k++]=num;
        }
        return res;
    }
}
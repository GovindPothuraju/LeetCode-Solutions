class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for(int num: nums){
            if(num==pivot)equal.add(num);
            else if(num>pivot)greater.add(num);
            else less.add(num);
        }
        int k=0;
        for(int i=0;i<less.size();i++){
            nums[k++]=less.get(i);
        }
        for(int i=0;i<equal.size();i++){
            nums[k++]=equal.get(i);
        }
        for(int i=0;i<greater.size();i++){
            nums[k++]=greater.get(i);
        }
        return nums;
        
    }
}
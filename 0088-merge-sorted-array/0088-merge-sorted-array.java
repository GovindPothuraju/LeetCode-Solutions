class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        int n1=nums1.length;
        int n2=nums2.length;
        for(int i=0;i<n1;i++){
            if(nums1[i]==0 && j<n2){
                nums1[i]=nums2[j];
                j++;
            }
        }
        Arrays.sort(nums1);
        
    }
}
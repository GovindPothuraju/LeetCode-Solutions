class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*List<List<Integer>>  oarr =new ArrayList<>();
        int n=nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> iarr = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(iarr);
                        if (!oarr.contains(iarr)) {
                            oarr.add(iarr);
                        }
                    }
                }
            }
        }
        return oarr;*/

        // using hashing
        List<List<Integer>>  oarr =new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            HashSet<Integer> hs=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int a=nums[i];
                int b=nums[j];
                int c=-a-b;
                if(hs.contains(c)){
                    List<Integer> triplet = Arrays.asList(a,b,c);
                    Collections.sort(triplet) ;
                    set.add(triplet);     
                }else{
                    hs.add(b);
                }
            }
        }
        
        oarr.addAll(set);
        return oarr;
    }
}

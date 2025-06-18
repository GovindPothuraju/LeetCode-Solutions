class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=names.length;
        String[] res=new String[n];
        for(int i=0;i<heights.length;i++){
            hm.put(heights[i],i);
        }
        Arrays.sort(heights);
        int l=0;
        int r=heights.length-1;
        while(l<r){
            int temp=heights[l];
            heights[l]=heights[r];
            heights[r]=temp;
            l++;
            r--;
        }
        int j=0;
        for(int i=0;i<heights.length;i++){
            int val=hm.get(heights[i]);
            res[j++]=names[val];

        }
        return res;
    }
}
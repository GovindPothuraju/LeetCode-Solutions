class Solution {
    // 1. brute force approach and its meet TLE
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    //     PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->(b.get(0)+b.get(1))-(a.get(0)+a.get(1)));
    //     for(int i=0;i<nums1.length;i++){
    //         for(int j=0;j<nums2.length;j++){
    //             List<Integer> temp=Arrays.asList(nums1[i], nums2[j]);
    //             pq.add(temp);
    //             while(pq.size()>k){
    //                 pq.poll();
    //             }
    //         }
    //     }
    //     System.out.println(pq);
    //     List<List<Integer>> res=new ArrayList<>();
    //     while(!pq.isEmpty()){
    //         res.add(pq.poll());
    //     }
    //     return res;

    // }
    

    // top k least pairs 
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<>();

        int n=nums1.length;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashSet<String> hs=new HashSet<>();

        pq.add(new int[]{nums1[0]+nums2[0],0,0});
        hs.add("0,0");

        while(k-->0 && !pq.isEmpty()){
            int[] temp=pq.poll();
            int sum=temp[0];
            int i=temp[1];
            int j=temp[2];

            res.add(Arrays.asList(nums1[i],nums2[j]));

            if(i+1<nums1.length && !hs.contains((i+1)+","+j)){
                pq.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
                hs.add((i+1)+","+j);
            }

            if(j+1<nums2.length && !hs.contains(i+","+(j+1))){
                pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
                hs.add(i+","+(j+1));
            }

        }

        return res;

    }
}
class Solution {
    public List<List<Long>> splitPainting(int[][] arr) {

        TreeMap<Integer,Long> tm=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            int st=arr[i][0];
            int end=arr[i][1];
            int color=arr[i][2];

            tm.put(st,tm.getOrDefault(st,0L)+color);
            tm.put(end,tm.getOrDefault(end,0L)-color);
        }

        List<List<Long>> res=new ArrayList<>();

        long sum=0;
        long st=0;
        for(int key : tm.keySet()){
            
            if(st!=0 && sum>0){
                res.add(Arrays.asList((long)st,(long)key,sum));
            }
            //update sum
            sum+=tm.get(key);
            //change key
            st=key;
        }
        return res;
    }
}
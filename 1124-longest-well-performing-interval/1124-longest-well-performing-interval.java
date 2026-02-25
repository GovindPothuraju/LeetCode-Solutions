class Solution {
    public int longestWPI(int[] arr) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int count=0;
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>8)count++;
            else count--;
            
            if(count>0){
                res=Math.max(res,i+1);
            }
            
            if(!hm.containsKey(count)){
                hm.put(count,i);
            }
            
            if(hm.containsKey(count-1)){
                res=Math.max(res,i-hm.get(count-1));
            }
        }
        return res;
    }
}
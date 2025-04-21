class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=fruits.length;
        int ans=0;
        int l=0;
        int temp=0;
        for(int r=0;r<n;r++){
            temp=fruits[r];
            hm.put(temp,hm.getOrDefault(temp,0)+1);
            while(hm.size() > 2){
                int val=fruits[l];
                hm.put(val,hm.get(val)-1);
                if(hm.get(val) == 0){
                    hm.remove(val);
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
class Solution {
    public int maxDifference(String s) {
        int n=s.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer> oddfreq=new ArrayList<>();
        ArrayList<Integer> evenfreq=new ArrayList<>();
        for(int val:hm.values()){
            if(val%2 != 0){
                oddfreq.add(val);
            }else{
                evenfreq.add(val);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int odd:oddfreq){
            for(int even : evenfreq){
                max=Math.max(max,odd-even);
            }
        }
        return max;
    }
}
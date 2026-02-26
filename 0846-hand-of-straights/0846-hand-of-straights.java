class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize != 0) return false;

        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i=0;i<n;i++){
            tm.put(hand[i],tm.getOrDefault(hand[i],0)+1);
        }
        while(!tm.isEmpty()){
            int small=tm.firstKey();
            for(int i=0;i<groupSize;i++){
                int card=small+i;

                if(!tm.containsKey(card))return false;
                if(tm.containsKey(card)){
                    tm.put(card,tm.get(card)-1);
                }
                if(tm.get(card)==0){
                    tm.remove(card);
                }
            }
        }
        return true;
    }
}
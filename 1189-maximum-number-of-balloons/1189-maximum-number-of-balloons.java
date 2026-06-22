class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        if(n<7)return 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = text.charAt(i);
            if(ch=='b'||ch=='a'||ch=='l'||ch=='o'||ch=='n'){
                hm.put(ch,hm.getOrDefault(ch,0)+1);
            }
        }
        return Math.min(
        Math.min(hm.getOrDefault('b',0),
                hm.getOrDefault('a',0)),
        Math.min(
            hm.getOrDefault('l',0)/2,
            Math.min(
                hm.getOrDefault('o',0)/2,
                hm.getOrDefault('n',0)
            )
        )
    );
    }
}
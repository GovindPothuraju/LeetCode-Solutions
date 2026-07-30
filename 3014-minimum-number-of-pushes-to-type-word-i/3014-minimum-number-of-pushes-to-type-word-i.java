class Solution {
    public int minimumPushes(String word) {
        int n = word.length();

        int req = n/8;
        if(n%8 != 0){
            req++;
        }
        
        if(req==2){
            return 8+((n-8)*2);
        }else if(req == 3){
            return 8+16+((n-16)*3);
        }else if(req == 4){
            return 8+16+24+((n-24)*4);
        }
        return n;
    }
}
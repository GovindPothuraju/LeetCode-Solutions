class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        s = "1" + s + "1";
        int n = s.length();
        int count = 0;
        for(int i=1;i<n-1;i++){
            char ch = s.charAt(i);
            if(ch=='1')count++;
        }
        int i = 1;
        int maxGain = 0;
        int leftZero=0;
        while(i<n-1){
            //left zero block
            while(i<n && s.charAt(i)=='0'){
                leftZero++;
                i++;
            }
            //middle one block
            int oneBlock=0;
            while(i<n && s.charAt(i)=='1'){
                oneBlock++;
                i++;
            }
            //right zero block
            int rightZero =0;
            while(i<n && s.charAt(i)=='0'){
                rightZero++;
                i++;
            }
            if(leftZero>0 && oneBlock >0 && rightZero>0){
                maxGain = Math.max(maxGain,leftZero+rightZero);
            }
            leftZero = rightZero;
        }
        return count+maxGain;
    }
}
class Solution {
    public int maxFreqSum(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            arr[ch-'a']++;
        }
        String vowels="aeiou";
        int maxv=0;
        int maxc=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(vowels.indexOf(ch) != -1){
                maxv=Math.max(maxv,arr[ch-'a']);
            }else{
                maxc=Math.max(maxc,arr[ch-'a']);
            }
        }
        return maxc+maxv;
    }
}
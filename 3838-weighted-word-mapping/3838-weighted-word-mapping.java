class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        String lower = "zyxwvutsrqponmlkjihgfedcba" ;

        for(String word : words){
            int sum = 0;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                sum+=weights[ch-'a'];
            }
            sb.append(lower.charAt(sum%26));
        }
        return sb.toString();
    }
}
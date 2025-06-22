class Solution {
    public boolean checkIfPangram(String sentence) {
        int n=sentence.length();
        if(n<26) return false;
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            char ch=sentence.charAt(i);
            hs.add(ch);
        }
        return hs.size()==26;
    }
}
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        int n1=words.size();
        int n2=s.length();
        if(n1 != n2) return false;
        for(int i=0;i<n1;i++){
            if(words.get(i).charAt(0) != s.charAt(i)) return false;
        }
        return true;
    }
}
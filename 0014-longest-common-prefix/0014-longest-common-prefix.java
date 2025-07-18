class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int i=0;
        int j=0;
        String res="";
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)== s2.charAt(j)){
                res+=s1.charAt(i);
            }else{
                break;
            }
            i++;
            j++;
        }
        return res;
    }
}
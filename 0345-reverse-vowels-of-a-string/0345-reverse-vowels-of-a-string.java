class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> arr=new ArrayList<>();
        String vowels="aeiouAEIOU";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(vowels.indexOf(ch) !=-1){
                arr.add(ch);
            }
        }
        String res="";
        int j=arr.size()-1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(vowels.indexOf(ch) !=-1){
                res+=arr.get(j);
                j--;
            }else{
                res+=ch;
            }
        }
        return res;
    }
}
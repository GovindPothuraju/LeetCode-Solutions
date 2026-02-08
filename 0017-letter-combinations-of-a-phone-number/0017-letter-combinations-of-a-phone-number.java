class Solution {
    HashMap<Character,String> hm=new HashMap<>();
    int n;
    List<String> res=new ArrayList<>();
    int index=0;
    public List<String> letterCombinations(String digits) {
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        n=digits.length();

        backtrack(new StringBuilder(),0,digits);
        return res;
    }
    private void backtrack(StringBuilder sb,int index,String digits){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        String letters=hm.get(digits.charAt(index));

        for(int i=0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            backtrack(sb,index+1,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(new ArrayList<>(),s);
        return res;
    }
    private void backtrack(List<String> path , String remainingString){
        if(remainingString.length()==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<remainingString.length();i++){
            String sub=remainingString.substring(0,i+1);
            System.out.println(sub);
            // if not a palindrome then continue
            if(!isPalindrome(sub))continue;

            path.add(sub);
            backtrack(path,remainingString.substring(i+1));
            path.remove(path.size()-1);
        }
    }
    private boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))return false;
        }
        return true;
    }
}
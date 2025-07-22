class Solution {
    public int maxDepth(String s) {
        int temp=0,max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') temp++;
            else if(ch==')') temp--;
            else continue;
            max=Math.max(max,temp);
        }
        return max;
    }
}
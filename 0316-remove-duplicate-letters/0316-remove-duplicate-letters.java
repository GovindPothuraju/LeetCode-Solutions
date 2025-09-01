class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        Stack<Character> st=new Stack<>();
        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int[] chars=new int[26];


        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.get(ch)-1);

            if(chars[ch-'a'] == 1) continue;
            
            while(!st.isEmpty() && st.peek()>ch && hm.get(st.peek())>0){
                chars[st.pop()-'a']=0;
            }
            st.push(ch);
            chars[ch-'a']=1;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);
        
        return sb.toString();

    }
}
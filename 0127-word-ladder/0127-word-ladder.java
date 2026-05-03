class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs=new HashSet<>();
        for(String s:wordList){
            hs.add(s);
        }
        if(!hs.contains(endWord))return 0;

        int count=1;
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);

       
        while(!q.isEmpty()){
            int n=q.size();
            for(int k=0;k<n;k++){
                StringBuilder s = new StringBuilder(q.poll());
                if(s.toString().equals(endWord)) return count;
                // for every character in a string is replaced by 
                for(int i=0;i<s.length();i++){
                    char temp=s.charAt(i);
                    // 26 characters and check in hs
                    for(int j=0;j<26;j++){
                        char replace=(char)('a'+j);
                        s.setCharAt(i,replace);
                        if(hs.contains(s.toString())){
                            q.offer(s.toString());
                            hs.remove(s.toString());
                        }
                    }
                    // again get back to my original string
                    s.setCharAt(i,temp);
                }
            }
            count++;
        }
        return 0;
    }
}
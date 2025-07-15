class Solution {
    public int lengthOfLastWord(String s) {
        /*String news=s.trim();
        int count=0;
        int n=news.length();
        System.out.println(n);
        System.out.println(news);
        for(int i=n-1;i>=0;i--){
            char ch=news.charAt(i);
            if(ch != ' '){
                count++;
            }else{
                break;
            }
        }
        return count;*/
        String[] words=s.split(" ");
        String last=words[words.length-1];
        return last.length();
    }
}
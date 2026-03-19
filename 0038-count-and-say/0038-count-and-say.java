class Solution {
    public String countAndSay(int k) {
        String s="1";
        for(int i=1;i<k;i++){
            s=generate(s);
        }
        return s;
    }
    private String generate(String s){
        int count=1;
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)==s.charAt(i)){
                count++;
            }else{
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count=1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(n - 1));
        return sb.toString();
    }
}
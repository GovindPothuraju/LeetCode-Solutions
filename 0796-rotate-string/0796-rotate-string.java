class Solution {
    public boolean rotateString(String s, String goal) {
        /* it fails for some test cases
        int n1=s.length();
        int n2=goal.length();
        if(n1 != n2) return false;
        char check=goal.charAt(0);
        int i=1;
        while(i<n1){
            if(s.charAt(i) == check){
                break;
            }
            i++;
        }
        int j=0;
        while(j<n2){
            if(s.charAt(i%n1)!= goal.charAt(j%n2)){
                return false;
            }
            System.out.println(i+" "+j);
            i++;
            j++;
        }
        return true;*/
        /*int n1=s.length();
        int n2=goal.length();
        for(int i=0;i<n1;i++){
            String news=s.substring(i,n1)+s.substring(0,i);
            if(news.equals(goal)) return true;
        }
        return false;*/
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
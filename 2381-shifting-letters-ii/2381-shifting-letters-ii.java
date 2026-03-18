class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] diff=new int[n];

        for(int[] shift : shifts){
            int st=shift[0];
            int ed=shift[1];
            int dir=shift[2];

            int val = ( dir==1 )? 1 : -1;
            
            diff[st] += val ;
            if(ed+1 < n)diff[ed+1]-=val;
        }
        // caluculate prefix sum
        for(int i=1;i<n;i++){
            diff[i]+=diff[i-1];
        }

       StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int shift=((diff[i]%26)+26)%26; //handle negative numbers
            char ch = s.charAt(i);
            char newChar = (char)((ch - 'a' + shift) % 26 + 'a');
            res.append(newChar);
        }
        return res.toString();
    }
}
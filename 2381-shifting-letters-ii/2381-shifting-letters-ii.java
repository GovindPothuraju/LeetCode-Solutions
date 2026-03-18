class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] arr=new int[n];

        for(int i=0;i<shifts.length;i++){
            int st=shifts[i][0];
            int ed=shifts[i][1];
            int x=shifts[i][2];

            if(x==0){
                arr[st]--;
                if(ed+1 < n)arr[ed+1]++;
            }else{
                arr[st]++;
                if(ed+1 < n)arr[ed+1]--;
            }
        }
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
       System.out.println( Arrays.toString(arr));

       StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int shift=((arr[i]%26)+26)%26;
            char ch = s.charAt(i);
            char newChar = (char)((ch - 'a' + shift) % 26 + 'a');
            res.append(newChar);
        }
        return res.toString();
    }
}
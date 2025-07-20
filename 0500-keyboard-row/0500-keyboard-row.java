class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> res=new ArrayList<>();
        String first="qwertyuiop";
        String second="asdfghjkl";
        String third="zxcvbnm";
        for(int i=0;i<words.length;i++){
            String temp=words[i];
            int n=temp.length();
            int v1=0,v2=0,v3=0;;
            for(int j=0;j<n;j++){
                if(first.indexOf(Character.toLowerCase(temp.charAt(j))) != -1){
                    v1++;
                }else if(second.indexOf(Character.toLowerCase(temp.charAt(j))) != -1){
                    v2++;
                }else if(third.indexOf(Character.toLowerCase(temp.charAt(j))) != -1){
                    v3++;
                }
            }
            int count=0;
            if(v1==0) count++;
            if(v2==0) count++;
            if(v3==0) count++;
            if(count>=2){
                res.add(temp);
            }
        }
        String[] out=res.toArray(new String[0]);
        return out;
    }
}
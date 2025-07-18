class Solution {
    public String largestOddNumber(String num) {
        /*int len= num.length();
        for(int i=len-1;i>=0;i--){
            if(num.charAt(i)%2==1){
                return num.substring(0, i + 1);
            }
        }
        return "";*/
        int val=0,index=-1;
        for(int i=0;i<num.length();i++){
            val =num.charAt(i)-'0';
            if(val%2 != 0){
                index=i;
            }
        }
        if(index==-1){
            return "";
        }else{
            return num.substring(0,index+1);
        }
    }
}
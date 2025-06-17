class Solution {
    public int calPoints(String[] operations) {
        int n=operations.length;
        int res[]=new int[n];
        int fres=0;
        int j=0;
        for(int i=0;i<n;i++){
            String op=operations[i];
            if(op.equals("+")){
                res[j]=res[j-1]+res[j-2];
                j++;
            }else if(op.equals("D")){
                res[j]=res[j-1]*2;
                j++;
            }else if(op.equals("C")){
                j--;
                res[j]=0;
            }else{
                res[j]=Integer.parseInt(op);
                j++;
            }
        }
        for(int i=0;i<res.length;i++){
            fres+=res[i];
        }
        return fres;
    }
}
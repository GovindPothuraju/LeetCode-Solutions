class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> res=new ArrayList<>();
        int n=arr.length;
        int i=0;
        while(i<n){
                int correct=arr[i]-1;
                if(arr[i] != arr[correct]){
                    int temp=arr[i];
                    arr[i]=arr[correct];
                    arr[correct]=temp;
                }else{
                    i++;
                }
        }
        for(i=0;i<n;i++){
            if(arr[i] != i+1){
                res.add(arr[i]);
            }
        }
        return res;
    }
}
class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        int n=arr.length;
        int i=0;
        ArrayList<Integer> res=new ArrayList<>();
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
            if(arr[i]-1 != i){
                res.add(i+1);
            }
        }
        return res;
    }
}
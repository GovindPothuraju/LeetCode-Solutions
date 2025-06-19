class Solution {
    public int findDuplicate(int[] arr) {
        /*HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int key=nums[i];
            if(!hm.containsKey(key)){
                hm.put(key,hm.getOrDefault(key,0)+1);
            }else{
                return key;
            }
        }
        return 0;*/
        // using cycle sort
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
                return arr[i];
            }
        }
        return -1;
    }
}
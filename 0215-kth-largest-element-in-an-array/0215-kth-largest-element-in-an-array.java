class Solution {
    ArrayList<Integer> arr=new ArrayList<>();
    int n;
    public int findKthLargest(int[] nums, int k) {
        this.n=nums.length;

        for(int i=0;i<n;i++){
            arr.add(nums[i]);
        }
        //build a max heap
        for(int i=n/2-1;i>=0;i--){
            heapifyDown(i);
        }
        int count=1;
        while(count<k){
            int temp = arr.get(0);
            arr.set(0, arr.get(n-1));
            arr.set(n-1, temp);

            n--;

            heapifyDown(0);
            count++;
        }
        return arr.get(0);
    }
    private void heapifyDown(int i){
        int leftChild=2*i+1;
        int rightChild=2*i+2;

        int largest=i;
        if(leftChild<n && arr.get(leftChild)>=arr.get(largest)){
            largest=leftChild;
        }
        if(rightChild<n && arr.get(rightChild)>=arr.get(largest)){
            largest=rightChild;
        }
        if(largest!=i){

            int temp = arr.get(largest);
            arr.set(largest, arr.get(i));
            arr.set(i, temp);

            heapifyDown(largest);
        }

    }
}
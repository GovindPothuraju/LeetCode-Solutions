class Solution {
    public int[] sortArray(int[] arr) {
        mergesort(arr,0,arr.length-1);
        return arr;
    }
    public void mergesort(int[] arr,int l,int r){
        if(l<r){
        int mid=l+(r-l)/2;
        mergesort(arr,l,mid);
        mergesort(arr,mid+1,r);
        merge(arr,l,mid,r);}
    }
    
    public void merge(int[] arr ,int l,int mid,int r){
        int[] temp=new int [r-l+1];
        int i=l;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=r){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=r){
            temp[k++]=arr[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            arr[l + p] = temp[p];
        }
   
    }
}


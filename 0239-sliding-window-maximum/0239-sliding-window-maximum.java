class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        /*int n=arr.length;
        int[] res=new int[n-k+1];
        int count=0;
        if(n<=3){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                max=Math.max(max,arr[i]);
            }
            res[count++]=max;
        }else {
            for(int l=0;l<n-2;l++){
                int max=Integer.MIN_VALUE;
                int r=l+k-1;
                for(int i=l;i<=r;i++){
                    max=Math.max(max,arr[i]);
                }
                res[count++]=max;
            }
        }
        return res;
        
        T.c o(n-k)*k
        s.c o(n-k)*/
        


      /*  Queue<Integer> q=new LinkedList<>();
        int max=-1,j=0;
        int n=arr.length;
        int[] res=new int[n-k+1];
        for(int i=0;i<n;i++){
            int val=arr[i];
            q.offer(val);
            max=Math.max(max,val);
            if(q.size()==k){
                res[j++]=max;
                if(q.poll()==max){
                    max=val;
                }
            }
        }
        return res;*/

        Deque<Integer> q=new LinkedList<>();
        int n=arr.length;
        int j=0;
        int res[]=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peek()==i-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && arr[q.peekLast()]<arr[i]){
                q.removeLast();
            }
            q.offer(i);
            if(i>=k-1){
                res[j++]=arr[q.peek()];
            }
        }
        return res;
    }
}
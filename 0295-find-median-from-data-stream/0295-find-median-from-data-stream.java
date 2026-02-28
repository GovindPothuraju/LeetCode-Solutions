class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    int count=0;
    public MedianFinder() {
        pq1=new PriorityQueue<>(Collections.reverseOrder());//max heap
        pq2=new PriorityQueue<>();//min heap
    }
    
    public void addNum(int num) {
        count++;
        if(pq1.isEmpty() || num <= pq1.peek()){
            pq1.add(num);
        }else{
            pq2.add(num);
        }

        if(pq1.size() > pq2.size()+1){
            pq2.add(pq1.poll());
        }else if(pq2.size() > pq1.size()){
            pq1.add(pq2.poll());
        }
    }
    
    public double findMedian() {
        if(count%2==0){
            int sum=pq1.peek()+pq2.peek();
            return sum/2.0;
        }
        return (double)(pq1.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
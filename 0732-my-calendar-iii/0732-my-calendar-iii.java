class MyCalendarThree {
    TreeMap<Integer,Integer> events;
    public MyCalendarThree() {
        events=new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        events.put(startTime,events.getOrDefault(startTime,0)+1);
        events.put(endTime,events.getOrDefault(endTime,0)-1);
        int max=Integer.MIN_VALUE;
        int curr=0;
        for(int e:events.values()){
            curr+=e;
            max=Math.max(max,curr);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
class MinStack {
    /*Stack<Integer> s;
    public MinStack() {
        s=new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<s.size();i++){
            min=Math.min(min,s.get(i));
        }
        return min;
    }*/
    Stack<Integer> s;
    Stack<Integer> minStack;
    public MinStack() {
        s=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
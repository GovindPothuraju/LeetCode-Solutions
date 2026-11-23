class ProductOfNumbers {
    ArrayList<Integer> arr = new ArrayList<>();
    public ProductOfNumbers() {
        arr = new ArrayList<>();
    }
    
    public void add(int num) {
        arr.add(num);
    }
    
    public int getProduct(int k) {
        int res = 1;
        int n =arr.size();
        for(int i=n-1 ; i>n-k-1 ; i--){
            res = res*arr.get(i);
        }
        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
class Solution {
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int fib(int n) {
        if(n<2){
            return n;
        }
        if(hm.containsKey(n)){
            return hm.get(n);
        }
        int result= fib(n-1)+fib(n-2);
        hm.put(n,result);
        return result;
    }
}
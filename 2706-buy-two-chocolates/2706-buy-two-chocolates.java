class Solution {
    public int buyChoco(int[] prices, int money) {
      Arrays.sort(prices);
      int sum=prices[0]+prices[1];
      int res=0;
      if(money-sum < 0){
        res=money;
      }else{
        res=money-sum;
      }
      return res;
    }
}
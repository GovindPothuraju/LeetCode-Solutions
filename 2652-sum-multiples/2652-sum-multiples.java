class Solution {
    public int sumOfMultiples(int n) {
        int sum=0;
        for(int i=3;i<=n;i++){
            if(i%3 ==0 || i%5==0 || i%7==0){
                sum+=i;
            }
        }
        return sum;
        // using formula Inclusion-Exclusion Principle
        /*return sumDivisibleBy(n,3)+sumDivisibleBy(n,5)+sumDivisibleBy(n,7)-sumDivisibleBy(n,lcm(3,5))-sumDivisibleBy(n,lcm(3,7))-sumDivisibleBy(n,lcm(7,5))+sumDivisibleBy(n,lcm(3,lcm(5,7)));
    }
    private int sumDivisibleBy(int n, int k) {
        int m = n / k;
        return k * m * (m + 1) / 2;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }*/
}
}


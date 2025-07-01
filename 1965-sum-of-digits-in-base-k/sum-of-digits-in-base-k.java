class Solution {
    public int sumBase(int n, int k) {
        int rem=0;
        while(n>0){
            rem=n%k+rem;
            n=n/k;
        }
        return rem;
    }
}
class Solution {
     public int numWaterBottles(int numBottles, int numExchange) {
        int total=numBottles;
        int rem=numBottles;
        while(rem>=numExchange) {
            int full=rem/numExchange;
            total+=full;
            rem=rem%numExchange+full;
        }
        return total;
    }
}
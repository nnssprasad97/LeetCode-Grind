class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int first=cost[0];
       int second=cost[1];
       for(int i=2;i<cost.length;i++){
        int totalcost=cost[i]+Math.min(first,second);
        first=second;
        second=totalcost;
       }
       return Math.min(first,second);
    }
}
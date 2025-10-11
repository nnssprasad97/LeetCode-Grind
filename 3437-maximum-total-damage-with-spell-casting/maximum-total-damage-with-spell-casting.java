import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : power)count.put(x, count.getOrDefault(x, 0) + 1);
        List<Integer> unique = new ArrayList<>(count.keySet());
        Collections.sort(unique);
        int n=unique.size();
        long[] dp=new long[n+1];
        for(int i=1;i<=n;i++){
            int x=unique.get(i-1);
            long total=(long)x*count.get(x);
            int j=Collections.binarySearch(unique,x-2);
            if(j<0)j=-j-1;
            j = j;
            dp[i]=Math.max(dp[i-1],total+dp[j]);
        }
        return dp[n];
    }
}

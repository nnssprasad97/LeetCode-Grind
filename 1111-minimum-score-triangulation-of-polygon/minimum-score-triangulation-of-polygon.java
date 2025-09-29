class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        Integer[][] memo = new Integer[n][n];
        return solve(values, 0, n - 1, memo);
    }
    private int solve(int[] v, int i, int j, Integer[][] memo) {
        if (j - i < 2) return 0; // no triangle possible
        if (memo[i][j] != null) return memo[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = v[i] * v[k] * v[j]
                     + solve(v, i, k, memo)
                     + solve(v, k, j, memo);
            ans = Math.min(ans, cost);
        }
        return memo[i][j] = ans;
    }
}

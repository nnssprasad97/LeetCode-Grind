class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length,sum=0;
        if(n%2!=0)sum-=mat[n/2][n/2];
        for(int i=0;i<n;i++)sum+=mat[i][i];
        for(int j=0;j<n;j++)sum+=mat[n-j-1][j];
        return sum;
    }
}
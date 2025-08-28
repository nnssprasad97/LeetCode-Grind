import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        // Step 1: handle diagonals starting from top row
        for(int j=n-1;j>=0;j--)processDiagonal(0,j,grid,n);
        // Step 2: handle diagonals starting from left column
        for(int i=1;i<n;i++)processDiagonal(i,0,grid,n);
        return grid;
    }

    private void processDiagonal(int i, int j, int[][] grid, int n) {
        List<Integer> diag = new ArrayList<>();
        int x = i, y = j;
        // Collect diagonal wise elements of matrix
        while (x < n && y < n) {
            diag.add(grid[x][y]);
            x++;
            y++;
        }
        // Sorting them depending on region
        if (i == 0 && j > 0) Collections.sort(diag);
            // Top-right region = non-decreasing(increase or equal)
        else diag.sort(Collections.reverseOrder());
            // Bottom-left with diagonals = non-increasing(decrease or equal)
        x = i;
        y = j;
        int k = 0;
        while(x<n && y<n){
            grid[x][y]=diag.get(k++);
            x++;
            y++;
        }
    }
}

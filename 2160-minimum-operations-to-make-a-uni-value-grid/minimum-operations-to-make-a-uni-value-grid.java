class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m * n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[k++] = grid[i][j];
            }
        }
        
        if (nums.length == 1) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[0]) % x != 0) {
                return -1;
            }
        }
        
        int mid = nums.length / 2;
        int median = nums[mid];
        
        int operations = 0;
        for (int num : nums) {
            operations += Math.abs(num - median) / x;
        }
        
        return operations;
    }
}
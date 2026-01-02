class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length/2;
        Arrays.sort(nums);
        if(nums[n]==nums[n+1])return nums[n];
        return nums[n-1];
    }
}
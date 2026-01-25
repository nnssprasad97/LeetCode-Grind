class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        if(k==1)return 0;
        int mi=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<=n-k;i++)mi=Math.min(mi,nums[i+k-1]-nums[i]);
        return mi;
    }
}
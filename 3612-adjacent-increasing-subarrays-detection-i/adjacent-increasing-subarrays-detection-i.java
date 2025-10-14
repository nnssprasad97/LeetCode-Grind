class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
         int n=nums.size();
        if(n<2*k) return false;
        int[] inc=new int[n];
        inc[0]=1;
        for(int i=1;i<n;i++){
            inc[i]=nums.get(i)>nums.get(i-1)?inc[i-1]+1:1;
        }
        for(int i=0;i<=n-2*k;i++){
            if(inc[i+k-1]>=k && inc[i+2*k-1]>=k) return true;
        }
        return false;
    }
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int cnt=0,l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)k--;
            while(k<0){
            if(nums[l]==0)k++;
            l++;
           }
           cnt=Math.max(cnt,i-l+1);
        }
        return cnt;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] suf=new int[n];
        int pro=1;
        int bro=1;
        pre[0]=1;
        suf[0]=1;
        for(int i=1;i<n;i++){
            pro=pro*nums[i-1];
            pre[i]=pro;
            bro=bro*nums[n-i];
            suf[i]=bro;
        }
        for(int i=0;i<n;i++)nums[i]=pre[i]*suf[n-i-1];
        return nums;
    }
}
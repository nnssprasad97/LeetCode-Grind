class Solution {
    public void sortColors(int[] nums) {
        int cn0=0,cn1=0,cn2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)cn0++;
            if(nums[i]==1)cn1++;
            if(nums[i]==2)cn2++;
        }
        for(int i=0;i<cn0;i++)nums[i]=0;
        for(int i=cn0;i<cn0+cn1;i++)nums[i]=1;
        for(int i=cn0+cn1;i<cn0+cn1+cn2;i++)nums[i]=2;
    }
}
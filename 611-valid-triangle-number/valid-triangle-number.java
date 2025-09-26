class Solution {
    public int triangleNumber(int[] nums) {
        if(nums==null||nums.length<3)return 0;
        Arrays.sort(nums);
        int count=0,n=nums.length;
        for(int i=n-1;i>=2;i--){
            int c=nums[i];
            int left=0;
            int right=i-1;
            while(left<right){
                int a=nums[left];
                int b=nums[right];
                if(a+b>c){
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
class Solution {
    public int triangularSum(int[] nums) {
        return func(nums, nums.length);
    }

    private int func(int[] arr, int n){
        if(n==1) return arr[0]; //bc
        for(int i=0;i<n-1;i++){
            arr[i]=(arr[i]+arr[i+1]) %10; //already shrunk by -1 (size of the array)
        }
        return func(arr, n-1); //cuz after every step array size will dec by 1
    }
}
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int hash[] = new int[101];
        int max =0;
        for(int i =0;i<nums.length;i++){
            hash[nums[i]]++;
            max = Math.max(max,hash[nums[i]]);
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(hash[nums[i]]==max){
                sum+=1;
            }
        }
        return sum;
    }
}
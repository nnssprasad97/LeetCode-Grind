class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int maxi=0;
        for(int i=0;i<nums.length;i++){
           int y=map.getOrDefault(nums[i],0)+1;
           map.put(nums[i],y);
           maxi=Math.max(maxi,y);
        }
        int sum=0;
        for(int f:map.values()){
            if(maxi==f)sum+=f;
        }
        return sum;
    }
}
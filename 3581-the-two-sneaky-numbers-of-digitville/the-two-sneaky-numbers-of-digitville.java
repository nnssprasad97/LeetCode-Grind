class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int arr[]=new int[2];
        int l=0;
        Set<Integer>set=new HashSet<>();
        for(int i:nums)if(!set.add(i)){arr[l]=i;l++;}
        return arr;
    }
}
class Solution {
    public static boolean containsDuplicate(int[] nums) {
       Set<Integer>saw=new HashSet<>();
       for(int n:nums)if(!saw.add(n))return true;
       return false;
    }
}
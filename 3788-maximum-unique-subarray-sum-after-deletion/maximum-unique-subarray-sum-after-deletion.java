class Solution {
    public int maxSum(int[] nums) {
        int sum=0,mini=Integer.MIN_VALUE;
        boolean bo=false;
        Set<Integer>seen=new HashSet<>();
        for(int n:nums){
            if(n>0)bo=true;
            if(n>0 && seen.add(n))sum+=n;
            if(n<=0)mini=Math.max(mini,n);
        }
        seen.clear();
        if(bo)return sum;
        else return mini;
    }
}
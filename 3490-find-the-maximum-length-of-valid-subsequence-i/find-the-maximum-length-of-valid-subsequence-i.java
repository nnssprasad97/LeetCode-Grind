class Solution {
    public int maximumLength(int[] nums) {
        int evenCount = 0, oddCount = 0;
        for (int x : nums) {
            if (x % 2 == 0) evenCount++;
            else oddCount++;
        }
        int sameParity = Math.max(evenCount, oddCount);
        int alternate = findAlternating(nums);

        return Math.max(sameParity, alternate);
    }

    private int findAlternating(int[] nums) {
        int maxAlt = 1;
        int lastParity = nums[0] % 2;

        for (int i = 1; i < nums.length; i++) {
            int parity = nums[i] % 2;
            if (parity != lastParity) {
                maxAlt++;
                lastParity = parity;
            }
        }
        return maxAlt;
    }
}

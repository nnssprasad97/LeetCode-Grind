class Solution {
    public static int lowerBound(int[] arr, long x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans; // first index with value >= x
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long minPotionNeeded = (success + spells[i] - 1) / spells[i]; // ceil(success/spell)
            int index = lowerBound(potions, minPotionNeeded);
            res[i] = potions.length - index;
        }
        
        return res;
    }
}

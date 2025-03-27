import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        // Step 1: Find the dominant element in the whole array
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int dominant = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() * 2 > n) {
                dominant = entry.getKey();
                maxCount = entry.getValue();
                break;
            }
        }
        
        if (dominant == -1) return -1;
        
        // Step 2: Try to find the minimum index of a valid split
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }
            int rightCount = maxCount - leftCount;
            
            if (leftCount * 2 > (i + 1) && rightCount * 2 > (n - i - 1)) {
                return i;
            }
        }
        
        return -1;
    }
}

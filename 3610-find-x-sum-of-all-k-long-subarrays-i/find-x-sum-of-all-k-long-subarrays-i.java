import java.util.*;

public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] freq = new int[51];  // because 1 <= nums[i] <= 50

        // Initialize first window
        for (int i = 0; i < k; i++) {
            freq[nums[i]]++;
        }

        ans[0] = calcXSum(freq, x);
        for (int i = k; i < n; i++) {
            freq[nums[i - k]]--;
            freq[nums[i]]++;
            ans[i - k + 1] = calcXSum(freq, x);
        }

        return ans;
    }
    private int calcXSum(int[] freq, int x) {
        // Build list of (value, count)
        List<int[]> list = new ArrayList<>();
        for (int val = 1; val <= 50; val++) {
            if (freq[val] > 0) list.add(new int[]{val, freq[val]});
        }
        list.sort((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return b[0] - a[0];
        });

        int sum = 0;
        for (int i = 0; i < Math.min(x, list.size()); i++) {
            sum += list.get(i)[0] * list.get(i)[1];
        }

        return sum;
    }
}

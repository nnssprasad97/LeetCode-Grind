class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) continue;
            for (int d : new int[]{-1, 1}) {
                int[] arr = nums.clone();
                int curr = i, dir = d;
                while (curr >= 0 && curr < n) {
                    if (arr[curr] == 0) curr += dir;
                    else {
                        arr[curr]--;
                        dir = -dir;
                        curr += dir;
                    }
                }
                boolean ok = true;
                for (int v : arr) if (v != 0) { ok = false; break; }
                if (ok) res++;
            }
        }
        return res;
    }
}

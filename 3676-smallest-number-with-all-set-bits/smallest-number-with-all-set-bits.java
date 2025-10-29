class Solution {
    public int smallestNumber(int n) {
        int k = 1;
        while (true) {
            int x = (1 << k) - 1; // 2^k - 1, all bits set
            if (x >= n) {
                return x;
            }
            k++;
        }
    }
}
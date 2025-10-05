class Solution {
    public char kthCharacter(int k) {
        int cnt = Integer.bitCount(k - 1);
        return (char) ('a' + cnt);
    }
}

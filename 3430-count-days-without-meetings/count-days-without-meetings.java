class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int busyDays = 0, lastEnd = 0;
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > lastEnd + 1)busyDays += end - start + 1;
            else busyDays += Math.max(0, end - lastEnd);
            lastEnd = Math.max(lastEnd, end);
        }
        return days - busyDays;
    }
}

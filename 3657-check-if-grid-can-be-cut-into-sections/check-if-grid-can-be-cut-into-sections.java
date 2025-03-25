class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        //we will extract the intervals of the x
        int[][] x = new int[rectangles.length][2];
        for (int i = 0; i < rectangles.length; i++) {
            x[i][0] = rectangles[i][0];
            x[i][1] = rectangles[i][2];
        }
        //we will extrtact the y intervals here
        int[][] y = new int[rectangles.length][2];
        for (int i = 0; i < rectangles.length; i++) {
            y[i][0] = rectangles[i][1];
            y[i][1] = rectangles[i][3];
        }
        Arrays.sort(x, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(y, (a, b) -> Integer.compare(a[0], b[0]));
        return Math.max(
            countNonOverlapping(x),
            countNonOverlapping(y)
        ) >= 3;
    }
    private int countNonOverlapping(int[][] intervals) {
        int count = 0;
        int prevEnd = -1;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (prevEnd <= start) {
                count++;
                prevEnd = end;
            } else {
                prevEnd = Math.max(prevEnd, end); 
            }
        }
        return count;
    }
}
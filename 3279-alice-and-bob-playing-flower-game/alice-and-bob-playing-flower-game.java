class Solution {
    public long flowerGame(int n, int m) {
        return (((long)(n+1)/2)*(m/2)+((long)(m+1)/2)*(n/2));
    }
}
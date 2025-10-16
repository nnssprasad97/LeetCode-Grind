class Solution {
    public int findClosest(int x, int y, int z) {
        int xd=Math.abs(x-z);
        int yd=Math.abs(y-z);
        if(xd>yd)return 2;
        else if(xd<yd)return 1;
        else return 0;
    }
}
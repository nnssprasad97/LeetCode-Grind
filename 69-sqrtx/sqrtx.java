public class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x; // 0 and 1 are trivial
        }
        
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(mid==x/mid)return mid;
            else if(mid<x/mid)left=mid+1;
            else right=mid-1;
        }
        return right;
    }
}

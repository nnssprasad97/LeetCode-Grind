class Solution {
    public int totalMoney(int n) {
        int totalweeks=n/7;
        int remweeks=n%7;
        int fullweeksum=28*totalweeks+7*(totalweeks*(totalweeks-1)/2);
        int remweeksum=remweeks*totalweeks+(remweeks*(remweeks+1))/2;
        return fullweeksum+remweeksum;
    }
}
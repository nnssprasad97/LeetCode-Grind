class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double curhigh=0;
        int area=0;
        for(int i=0;i<dimensions.length;i++){
            int a=dimensions[i][0],b=dimensions[i][1];
            double dia=Math.sqrt(a*a+b*b);
            if(dia>curhigh){
                curhigh=dia;
                area=a*b;
            }
            if(dia==curhigh && a*b>area)area=a*b;
        }
        return area;
    }
}
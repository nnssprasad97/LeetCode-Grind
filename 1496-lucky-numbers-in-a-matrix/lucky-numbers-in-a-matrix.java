class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int m=matrix.length,n=matrix[0].length;
        int mini,maxi;
        for(int i=0;i<m;i++){
            mini=Integer.MAX_VALUE;
            int colIndex=-1;
            for(int j=0;j<n;j++){
                if(matrix[i][j]<mini){
                    mini=matrix[i][j];
                    colIndex=j;
                }
            }
            maxi=Integer.MIN_VALUE;
            for(int k=0;k<m;k++)maxi=Math.max(maxi,matrix[k][colIndex]);
            if(mini==maxi)list.add(mini);
        }
        return list;
    }
}

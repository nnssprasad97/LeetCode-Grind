class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length,n=mat[0].length,res[]=new int[m*n],k=0;
        for(int d=0;d<m+n-1;d++){
            if(d%2==0){
                int i=d<m?d:m-1,j=d-i;
                while(i>=0&&j<n)res[k++]=mat[i--][j++];
            }else{
                int j=d<n?d:n-1,i=d-j;
                while(i<m&&j>=0)res[k++]=mat[i++][j--];
            }
        }
        return res;
    }
}

class Solution {
    public int triangleNumber(int[] arr) {
        Arrays.sort(arr);
        int count = 0;

        int n=arr.length;
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

          
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
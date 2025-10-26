public class Solution {
    public String makeFancyString(String s) {
        char[] arr = s.toCharArray();
        int write = 0;
        for (int read = 0; read < arr.length; read++) {
            if (write >= 2 && arr[read] == arr[write - 1] && arr[read] == arr[write - 2]) {
                continue; // skip if it would create triple
            }
            arr[write++] = arr[read];
        }
        return new String(arr, 0, write);
    }
}
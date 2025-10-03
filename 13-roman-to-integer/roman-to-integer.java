//Input: s = "III"
//Output: 3
//Explanation: III = 3.

//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int previous = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            var current = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };

            if (previous > current) {
                total -= current;
            } else {
                total += current;
                previous = current;
            }

        }
        return total;
    }
}
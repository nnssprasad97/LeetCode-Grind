class Solution {
    public String largestGoodInteger(String num) {
        String s = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String t = num.substring(i, i + 3);
                if (s.equals("") || t.compareTo(s) > 0) s = t;
            }
        }
        return s;
    }
}

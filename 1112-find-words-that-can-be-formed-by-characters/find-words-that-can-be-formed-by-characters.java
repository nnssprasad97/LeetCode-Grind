class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];  // count of each letter in chars
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        int totalLength = 0;

        for (String word : words) {
            int[] wordCount = new int[26];
            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }

            if (canForm(wordCount, charCount)) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }

    private boolean canForm(int[] wordCount, int[] charCount) {
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] > charCount[i]) return false;
        }
        return true;
    }
}

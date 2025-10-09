class Solution {
    public long minTime(int[] skill, int[] mana) {
         int n = skill.length;
        int m = mana.length;
        long[] prefixSkill = new long[n];
        prefixSkill[0] = skill[0];
        for (int i = 1; i < n; i++) {
            prefixSkill[i] = prefixSkill[i - 1] + skill[i];
        }
        long[] prevFinish = new long[n];
        for (int i = 0; i < n; i++) {
            prevFinish[i] = prefixSkill[i] * mana[0];
        }
        for (int j = 1; j < m; j++) {
            long currentStart = 0;
            for (int i = 0; i < n; i++) {
                long sPrev = (i > 0) ? prefixSkill[i - 1] : 0;
                long lowerBound = prevFinish[i] - sPrev * mana[j];
                currentStart = Math.max(currentStart, lowerBound);
            }
            for (int i = 0; i < n; i++) {
                prevFinish[i] = currentStart + prefixSkill[i] * mana[j];
            }
        }
        return prevFinish[n - 1];
    }
}
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        Set<Integer>seen=new HashSet<>();
        int count=0;
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<baskets.length;j++){
                if(baskets[j]>=fruits[i] && seen.add(j))break;
            }
        }
        return fruits.length-seen.size();
    }
}
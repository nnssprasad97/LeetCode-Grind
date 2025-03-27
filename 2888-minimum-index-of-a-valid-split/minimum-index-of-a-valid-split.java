class Solution {
    public int minimumIndex(List<Integer> a) {
        int count = 0;
        int num = -1;
        int n = a.size();

        for(int i = 0; i < a.size(); i++){
            if(count == 0){
                num = a.get(i);
                count++;
            }
            else{
                if(num == a.get(i)) ++count;
                else --count;
            }
        }

        count = 0;
        for(int i = 0; i < n; i++) if(num == a.get(i)) ++count;

        int curr = 0;
        for(int i = 0; i < n; i++){
            if(a.get(i) == num){
                ++curr;
            }

            if(2 * curr > (i + 1) && 2 * (count - curr) > n - i - 1) return i;
        }

        return -1;


    }
}
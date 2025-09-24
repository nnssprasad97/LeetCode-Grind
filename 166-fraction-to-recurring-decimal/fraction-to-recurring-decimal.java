class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)return "0";
        StringBuilder s=new StringBuilder();
        if((numerator>0)^(denominator>0))s.append("-");
        long n=Math.abs((long)numerator);
        long d=Math.abs((long)denominator);
        s.append(n/d);
        long rem=n%d;
        if(rem==0)return s.toString();
        s.append('.');
        HashMap<Long,Integer>map=new HashMap<>();
        while(rem!=0){
            map.put(rem,s.length());
            rem*=10;
            s.append(rem/d);
            rem%=d;
            if(map.containsKey(rem)){
                int pos=map.get(rem);
                s.insert(pos,'(');
                s.append(')');
                break;
            }
        }
        return s.toString();
    }
}
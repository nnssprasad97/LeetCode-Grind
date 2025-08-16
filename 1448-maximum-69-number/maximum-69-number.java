class Solution {
    public int maximum69Number (int num) {
        StringBuilder s=new StringBuilder(String.valueOf(num));
        boolean b=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='6'){
                s.setCharAt(i,'9');
                return Integer.parseInt(s.toString());
            }
        }
        return num;
    }
}
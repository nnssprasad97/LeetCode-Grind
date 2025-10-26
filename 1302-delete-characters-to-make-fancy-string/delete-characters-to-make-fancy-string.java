class Solution {
    public String makeFancyString(String s) {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int len=res.length();
            char c=s.charAt(i);
            if(len<2 || !(res.charAt(len-1)==c && res.charAt(len-2)==c))res.append(c);
        }
        return res.toString();
    }
}

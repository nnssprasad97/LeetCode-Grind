class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int totalcount=0;
        StringBuilder s=new StringBuilder();
        while(totalcount<len1 && totalcount<len2){
            s.append(word1.charAt(totalcount));
            s.append(word2.charAt(totalcount));
            totalcount+=1;
        }
         if(totalcount<len1)s.append(word1.substring(totalcount));
         else if(totalcount<len2)s.append(word2.substring(totalcount));
         return s.toString();
    }
}
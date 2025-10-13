import java.util.*;
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String>result=new ArrayList<>();
        result.add(words[0]);
        for(int i=1;i<words.length;i++)if(!isAnagram(words[i],words[i-1]))result.add(words[i]);
        return result;
    }
    private boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length())return false;
        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
}

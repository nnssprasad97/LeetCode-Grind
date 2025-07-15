class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)return false;
        boolean isvowel=false,isconsonant=false;
        for(char c:word.toCharArray()){
            if(!((c>47 && c<58) || (c>64 && c<91) || (c>96 && c<123)))return false;
            if((c>64 && c<91) || (c>96 && c<123)){
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || 
                c=='E' || c=='I' || c=='O' ||   c=='U') isvowel=true;
                else isconsonant=true;
            }
        } 
        return (isvowel && isconsonant);
    }
}

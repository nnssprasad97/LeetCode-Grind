class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        String res=s.replaceAll("[^a-z0-9]","");
        int n=res.length();
        for(int i=0;i<n/2;i++){
            if(res.charAt(i)!=res.charAt(n-i-1))return false;
        }
        return true;
    }
}
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String>seen=new HashSet<>();
        Queue<String>q=new LinkedList<>();
        String small=s;
        q.offer(s);
        while(!q.isEmpty()){
            String cur=q.poll();
            if(!seen.add(cur))continue;
            if(cur.compareTo(small)<0)small=cur;
            String addnew=addnew(cur,a);
            String newrotate=newrotate(cur,b);
            q.offer(addnew);
            q.offer(newrotate);
        }
        return small;
    }
    public static String addnew(String s,int a){
        char[] arr=s.toCharArray();
        for(int i=1;i<arr.length;i+=2){
            int dig=(arr[i]-'0'+a)%10;
            arr[i]=(char)(dig+'0');
        }
        return new String(arr);
    }
    public static String newrotate(String s,int b){
        int n=s.length();
        b%=n;
        return s.substring(n-b)+s.substring(0,n-b);
    }
}
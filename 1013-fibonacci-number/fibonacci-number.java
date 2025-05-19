class Solution {
    public int fib(int n) {
        if(n<=1)return n;
        //return fib(n-1)+fib(n-2);
        //also this can be solved by
        int firstval=0,secondval=1,finalval=0;
        while(n>=2){
            finalval=firstval+secondval;
            firstval=secondval;
            secondval=finalval;
            n--;
        }
        return finalval;
    }
}
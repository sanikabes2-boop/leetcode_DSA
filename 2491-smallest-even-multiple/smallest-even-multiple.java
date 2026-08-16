class Solution {
    public int smallestEvenMultiple(int n) {
        /*
        int lcm = 0;
        for(int i=(n>2?n:2); ; i++){
            if((i%n == 0) && (i%2 == 0)){
                return i;
            }        
        }
        */
        return n % 2 == 0 ? n : n * 2;
    }
}
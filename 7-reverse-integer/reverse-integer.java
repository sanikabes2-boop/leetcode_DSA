class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int digit= x%10;
            x /= 10;
            //check conditions
            //We cannot calculate reverse * 10 first, because that itself might overflow.
            // REVERSE MUST STAY BETWEEN -2147483648  to  2147483647
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0;
            }
/*2147483640 + 7 = 2147483647  ✅
2147483640 + 8 = 2147483648  ❌ overflow*/

            if(rev < Integer.MIN_VALUE /10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)){
                return 0;
            }
/*-2147483640 + (-8) = -2147483648  ✅
-2147483640 + (-9) = -2147483649  ❌ overflow */
            rev = rev*10 + digit;

        }
        return rev;
    }
}
class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for(int num:nums){
             if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }      
        }
        while(min != 0){
            int rem = max % min;
            max = min;
            min = rem;
        }
        return max;
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /*1. Move right → increase the window.
2. If sum >= target → record length and move left to shrink.
3. Keep doing this → smallest valid window is the answer. */

    int left = 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        while(sum>=target){
            min = Math.min(min, right-left+1);
        //min is used to store the smallest valid subarray length we have found so far.
            sum -= nums[left];
            left++;
        }
    }
    return min == Integer.MAX_VALUE ? 0:min;
    }
}
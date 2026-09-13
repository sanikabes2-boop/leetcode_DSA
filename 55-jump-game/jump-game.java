class Solution {
    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index cannot be reached
            if (i > farthest) {
                return false;
            }

            // Update the farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }
}
class Solution {
    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // Find the farthest position
            farthest = Math.max(farthest, i + nums[i]);

            // Reached the boundary of current jump
            if (i == currentEnd) {

                jumps++;

                // New range for next jump
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
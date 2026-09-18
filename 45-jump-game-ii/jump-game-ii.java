class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            //Have I reached the end of the range that my current number of jumps can cover?            
            if (i == currentEnd) {

                jumps++;

                // New range for next jump
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
/*Instead of deciding exactly which index to jump to, we keep track of the farthest position we can reach with the current number of jumps.
    index:  0  1  2  3  4
    nums:   2  3  1  1  4
    sum:    2  4  3  4  X
currentEnd=The last index that we can reach using the current number of jumps.
farthest=what is the farthest index that we could reach with one more jump?
i + nums[i] = means current index ke phle tk ke steps+ no. of steps we can jump from the current index
*/
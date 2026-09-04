class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++){
            //so 1 to n each no. to appear in the array we go through each no.and make the (no.- 1)th index negative(just to mark it) and using Math.abs() to get the og no. while traversing
            int index = Math.abs(nums[i]) - 1;

            //now check if marked already or not
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }
        List<Integer> ans = new ArrayList<>(); //using arraylist       
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
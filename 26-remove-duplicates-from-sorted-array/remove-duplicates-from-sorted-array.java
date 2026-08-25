class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        for(int i=1; i<nums.length; i++){
            //if(!nums[i]^nums[i+1]){
              //  nums[i+1]= nums[i+2];
            //} !logical operator works with boolean
            if(nums[i-1] != nums[i]){
                nums[k] = nums[i];
                k++;
            }
            
        }
        return k;
    }
}
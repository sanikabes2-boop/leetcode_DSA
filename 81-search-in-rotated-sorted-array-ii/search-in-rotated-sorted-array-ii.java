/*class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot);
        }
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }

    public int findPivot(int[] nums){
        //here the pivot is 7 -> the left and right side of the pivot -> ascending bass 7 aur 0 hi descending hoga....
        //first find the pivot
        int start =0;
        int end =nums.length -1;
        while(start <= end){
            int mid=start +(end-start)/2;
            //"Is there an element after mid that I can compare with?"
            if(mid<end && nums[mid] > nums[mid+1] ){
                return mid;
            }
            //This is basically detecting the same drop, but from the other side.
            //"Is there an element before mid?"
            if(start<mid && nums[mid] < nums[mid-1]){
                return mid-1;
            }
            //to decide which side contains the pivot.

            //duplicate case:
            if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            else if(nums[start] >= nums[mid]){
                end= mid -1;
            }else{
                start = mid+1;
            }
        }
        return nums.length -1;//array not rotated
    }
    public boolean binarySearch(int[] nums, int target, int low, int high){
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (nums[mid] == target) {
                 return true; 
            } 
            if (nums[mid] < target) { 
                low = mid + 1;
            } else {
                high = mid - 1;
            } 
        } 
        return false;
    }
}*/

class Solution {
    public boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            //duplicate case:
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } 
            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
 
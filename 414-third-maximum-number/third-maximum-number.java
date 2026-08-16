class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null;//taking wrapper class so that it can store null value
        Integer second = null;
        Integer third = null;

        for(int num: nums){
            //dealing with the duplicates and ignoring them
            if((first != null && num == first) ||
            (second != null && num == second) ||
            (third != null && num == third))
                continue;

            if(first == null || num>first){
                third = second;
                second = first;
                first = num;
            }

            else if(second == null || num>second){
                third = second;            
                second = num;
            }

            else if(third == null || num>third){
                third = num;
            }
        }

        if(third == null){
            return first;
        }
        return third;

    }
}
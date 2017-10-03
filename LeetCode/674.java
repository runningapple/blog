class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            maxLength = maxLength > currentLength ? maxLength : currentLength;
        }  
        return maxLength;
    }
}
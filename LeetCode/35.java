class Solution {
    public int searchInsert(int[] nums, int target) {
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || target < nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
//还有更好的方法
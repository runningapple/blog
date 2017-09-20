class Solution {
    public void moveArrays(int[] nums, int beginIndex, int endIndex) {
        for (int i = beginIndex; i < endIndex; i++) {
            nums[i] ^= nums[i+1];
            nums[i+1] ^= nums[i];
            nums[i] ^= nums[i+1];
        }
    }

    public void moveZeroes(int[] nums) {

        // int tag = nums.length-1;
        int len = nums.length-1;
        int tagIndex = len;
        for (int i = len; i >= 0; i--) {
            if (nums[i] == 0) {
                moveArrays(nums, i, tagIndex);
                tagIndex--;
            }
        }


        //
        int tag = 0;
        for (int i = 0; i <= len; i++) {
            if (nums[i] != 0) {
                nums[tag++] = nums[i];
            }
        }
        while (tag <= len) {
            nums[tag++] = 0;
        }
    }
}
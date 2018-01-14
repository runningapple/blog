class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length-1;
        while (index > 0 && nums[index] <= nums[index-1]) {
            --index;
        }
        if (index == 0) {
            Arrays.sort(nums);
        } else {
            int secondIndex = Integer.MAX_VALUE;
            int secondNums = Integer.MAX_VALUE;
            for (int i = nums.length-1; i >= index; i--) {
                if (nums[i] > nums[index-1]) {
                    if (secondNums > nums[i]) {
                        secondIndex = i;
                        secondNums = nums[i];
                    }
                }
            }
            nums[index-1] ^= nums[secondIndex];
            nums[secondIndex] ^= nums[index-1];
            nums[index-1] ^= nums[secondIndex];
            Arrays.sort(nums, index, nums.length);
        }
    }
}

//还有更棒的方法
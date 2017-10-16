class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = k;
        int tmp = 0;
        for (int i = start; i < k; i++) {
            tmp += nums[i];
        }
        int result = tmp;
        for (int i = k; i < nums.length; i++) {
            tmp = tmp + nums[i] - nums[i-k];
            if (tmp > result) {
                result = tmp;
            }
        }
        return result;
    }
}
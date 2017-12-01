class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int differ = Integer.MAX_VALUE;
        int result = target;
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;
            int tmp = target-nums[i];
            while (j < k) {
                if (Math.abs(differ) > Math.abs(target-nums[i]-nums[j]-nums[k])) {
                    result = nums[i]+nums[j]+nums[k];
                    differ = target - result;
                }
                if (nums[j]+nums[k] < tmp) {
                    j++;
                } else if (nums[j]+nums[k] > tmp) {
                    k--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
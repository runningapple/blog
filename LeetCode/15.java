class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            List<Integer> tmp = null;
            int j = i+1, k = nums.length-1;
            if (j < k) {
                while (j < k && nums[j] + nums[k] + nums[i] < 0) {
                    j++;
                }
                if (j<k && nums[j] + nums[k] + nums[i] == 0) {
                    tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j++]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                }
                while (j < k && nums[j] + nums[k] + nums[i] > 0) {
                    k--;
                }
                if (j < k && nums[j] + nums[k] + nums[i] == 0) {
                    tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k--]);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i-1 >= 0 && nums[i] == nums[i-1]) continue;
            List<Integer> tmp = null;
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum == 0) {
                    tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                    while (j < k && nums[j] == nums[j+1]) ++j;
                    while (j < k && nums[k] == nums[k-1]) --k;
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}

//[-4,-1,-1,0,1,2]
//[-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
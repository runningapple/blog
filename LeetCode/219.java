class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set set = new HashSet<Integer>();
        int count = 0;
        if (k == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            if (count == k) {
                count -= 1;
                set.remove(nums[i-k]);
            }
            set.add(nums[i]);
            count++;
        }
        return false;        
    }
}
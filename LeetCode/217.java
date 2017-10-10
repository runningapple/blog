class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int item : nums) {
            set.add(item);
        }
        return !(nums.length == set.size());
    }
}
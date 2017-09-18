class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] tmp;
        k = len < k ? k-len : k;
        if (k == 0) {
            //do nothing
        } else if (len-k < k) {
            tmp = new int[len-k];
            System.arraycopy(nums, 0, tmp, 0, len-k);
            System.arraycopy(nums, len-k, nums, 0, k);
            System.arraycopy(tmp, 0, nums, k, len-k);
        } else {
            tmp = new int[k];
            System.arraycopy(nums, len-k, tmp, 0, k);
            System.arraycopy(nums, 0, nums, k, len-k);
            System.arraycopy(tmp, 0, nums, 0, k);
        }
    }
}
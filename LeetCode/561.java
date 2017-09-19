class Solution {
    
    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            sort(nums, left, mid);
            sort(nums, mid+1, right);
            merge(nums, left, mid, right);   
        }
    }
    
    private void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[right-left+1];
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        k = 0;
        for (int x = left; x <= right; x++) {
            nums[x] = tmp[k++];
        }
    }
    
    public int arrayPairSum(int[] nums) {
        sort(nums, 0, nums.length-1);
        int result = 0;
        for (int i = 0; i < nums.length>>1; i++) {
            result += nums[i<<1];
        }
        return result;
    }
}
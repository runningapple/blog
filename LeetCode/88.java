class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int k = n+m-1;
        int j = n-1;
        for (int i = m-1; i >= 0 && j >= 0; i--) {
            while (j >= 0 && nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            }
            nums1[k--] = nums1[i];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
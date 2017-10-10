class Solution {
    public int maximumProduct(int[] nums) {
        int[] tmp = {-1001, -1001, -1001, 1001, 1001};
        for (int item : nums) {
            if (tmp[0] < item) {
                tmp[0] = item;
                Arrays.sort(tmp, 0, 3);
            }
            if (item < tmp[4]) {
                tmp[4] = item;
                Arrays.sort(tmp, 3, 5);
            }
        }
        int a = tmp[0]*tmp[1]*tmp[2];
        int b = tmp[3]*tmp[4]*tmp[2];
        if (tmp[0] < 0 || tmp[1] < 0) return b;
        if (tmp[4] > 0 || tmp[3] > 0) return a;
        return a > b ? a : b;
    }
}
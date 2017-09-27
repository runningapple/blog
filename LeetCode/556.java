class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int x = nums.length;
        int y = nums[0].length;
        if ( x*y == r*c) {
            int[][] result = new int[r][c];
            for (int i = 0; i < x*y; i++) {
                result[i/c][i%c] = nums[i/y][i%y];
            }
            return result;
        } else {
            return nums;
        }
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int count = nums[0];
        int tmp = 0;
        for (int item : nums) {
            tmp += item;
            if (count < tmp) count = tmp;
            if (tmp < 0) tmp = 0;
        }
        return count;
    }
}
//for each 效率比下标遍历低些。三目运算和if else 判断需要看情况选择，毕竟赋值也是需要开销的
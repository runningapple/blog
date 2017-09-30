class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        int left = 0;
        int right = numbers.length-1;
        int tmp;
        while(left < right) {
            tmp = numbers[left] + numbers[right];
            if (tmp < target) {
                left++;
            } else if (tmp > target) {
                right--;
            } else {
                a[0] = left+1;
                a[1] = right+1;
                break;
            }
        }
        return a;
    }
}
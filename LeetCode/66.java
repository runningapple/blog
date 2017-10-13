class Solution {
    public int[] plusOne(int[] digits) {
       int[] result = new int[digits.length+1];
       int tmp = 1;
       for (int i = digits.length-1; i >= 0; i--) {
           result[i+1] = (digits[i] + tmp) % 10;
           tmp = (digits[i] + tmp) / 10;
       }
       if (tmp != 0) {
           result[0] = tmp;
           return result;
       } else {
           int[] result1 = new int[digits.length];
           System.arraycopy(result, 1, result1, 0, digits.length);
           return result1;
       }
    }
}
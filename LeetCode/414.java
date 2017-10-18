class Solution {
    public int thirdMax(int[] nums) {
        int one = Integer.MIN_VALUE;
        int two = Integer.MIN_VALUE;
        int three = Integer.MIN_VALUE;
        Set set = new HashSet<Integer>();
        for (int item : nums) {
            if (set.size() < 3) {
                set.add(item);
            }
            if (item > one) {
                three = two;
                two = one;
                one = item;
                continue;
            }
            if (item < one && item > two) {
                three = two;
                two = item;
                continue;
            }
            if (item < two && item > three) {
                three = item;
                continue;
            }
        }
        if (set.size() < 3) {
            return one;
        }
        return three;
    }
}
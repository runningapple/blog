class Solution {

class Item {
        private int cnt;
        private int start;
        private int end;

        public Item(int cnt, int start, int end) {
            this.cnt = cnt;
            this.start = start;
            this.end = end;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public int findShortestSubArray(int[] nums) {
        int cnt = 1;
        Map<Integer, Item> map = new HashMap<Integer, Item>();
        Item item;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                item = map.get(nums[i]);
                item.setEnd(i);
                item.setCnt(item.getCnt() + 1);
                if (cnt < item.getCnt() + 1) {
                    cnt = item.getCnt() + 1;
                }
            } else {
                item = new Item(nums[i], i, i);
                map.put(nums[i], item);
            }
        }
        int minIndexs = nums.length;
        for (Item tmp : map.values()) {
            if (tmp.getCnt() == cnt) {
                if (minIndexs > tmp.getEnd()-tmp.getStart()) {
                    minIndexs = tmp.getEnd()-tmp.getStart();
                }
            }
        }
        return minIndexs;
    }
}
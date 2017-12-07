/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) return 1;
                if (o1.val < o2.val) return -1;
                return 0;
            }
        };
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, comparator);
        ListNode node = new ListNode(0);
        ListNode result = node;
        for (ListNode item : lists) {
            if (item != null) {
               queue.add(item); 
            }
        }
        while (!queue.isEmpty()) {
            node.next = queue.poll();
            if (node.next.next != null) {
                queue.add(node.next.next);
            }
            node = node.next;
        }
        return result.next;
    }
}
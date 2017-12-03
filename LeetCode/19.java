/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 1;
        ListNode node = head;
        while (node.next != null) {
            cnt++;
            node = node.next;
        }
        int index = 1;
        node = head;
        while (index < cnt-n) {
            index++;
            node = node.next;
        }
        if (cnt == n) {
            return head.next;
        }
        if (cnt == 1) {
            head = null;
            return head;
        } 
        if (n == 1) {
            node.next = null;
        } else {
            node.next = node.next.next;
        }
        return head;
    }
}
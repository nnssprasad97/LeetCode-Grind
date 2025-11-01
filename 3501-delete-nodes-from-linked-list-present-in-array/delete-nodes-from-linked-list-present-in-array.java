/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
//     public ListNode modifiedList(int[] nums, ListNode head) {
//         ListNode dummy = new ListNode(0, head);
//         ListNode cur = dummy;
//         int[] cnt = new int[(int)Math.pow(10, 5) + 1];
//         for (int num : nums) {
//             cnt[num] ++;
//         }
//         while (cur.next != null) {
//             if (cnt[cur.next.val] == 1) {
//                 cur.next = cur.next.next;
//             } else {
//                 cur = cur.next;
//             }
//         }
//         return dummy.next;
//     }
// }

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>(nums.length, 1);
        for (int x : nums) {
            set.add(x);
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode nxt = cur.next;
            if (set.contains(nxt.val)) {
                cur.next = nxt.next;
            } else {
                cur = nxt;
            }
        }
        return dummy.next;
    }
}
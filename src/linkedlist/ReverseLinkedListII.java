package linkedlist;

/**
 * 92. Reverse Linked List II （局部链表反转）
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @author DanielQSL
 * @date 2019/1/29
 */
public class ReverseLinkedListII {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 额外多使用两个指针prev2、curr2
     * 讲解视频：https://www.bilibili.com/video/BV17a4y1Y78g?from=search&seid=9081255570633447883
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 1; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode prev2 = prev;
        ListNode curr2 = curr;
        for (int i = m; i <= n; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (prev2 != null) {
            prev2.next = prev;
        } else {
            head = prev;
        }
        curr2.next = curr;
        return head;
    }

}

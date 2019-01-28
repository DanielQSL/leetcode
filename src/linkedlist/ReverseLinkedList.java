package linkedlist;

/**
 * NO.206
 * Reverse a singly linked list.
 * 反转链表
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author DanielQSL
 * @date 2019/1/28
 */
public class ReverseLinkedList {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 解法一：
     * 使用循环的方式。
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next=prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }

}

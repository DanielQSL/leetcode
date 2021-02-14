package linkedlist;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @author qianshuailong
 * @date 2021/2/14
 */
public class MiddleOfTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }

    /**
     * 典型快慢指针
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // fast 一次前进两个元素，slow 一次前进一个元素
            fast = fast.next.next;
            slow = slow.next;
        }
        // 链表元素为奇数个时，slow 指向链表的中点
        // 链表元素为偶数个时，slow 指向链表两个中点的右边一个
        return slow;
    }

}

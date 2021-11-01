package linkedlist;

/**
 * 链表结点对象
 *
 * @author DanielQSL
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

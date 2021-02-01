package linkedlist;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * @author qianshuailong
 * @date 2021/2/1
 */
public class RemoveNthNodeFromEndOfList {

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

    /**
     * 双指针解法
     * 整体思路：是让前面的指针先移动n步，之后前后指针共同移动直到前面的指针到尾部为止
     * <p>
     * 注意：为了方便，我们在原有链表前面设置一个哑结点，哑结点的好处在于，因为这里我们是要删除一个结点，所以我们可以定位到被删除结点的前置结点，
     * 然后将前置结点的后续指针指向被删除结点的后续结点，则可完成删除。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
